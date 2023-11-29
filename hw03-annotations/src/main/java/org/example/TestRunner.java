package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRunner {

    public void runTestClass(String className) {
        Class<?> testClass = null;

        try {
            testClass = Class.forName(className);
        } catch (Exception ignored) {
        }

        assert testClass != null;
        Method[] methods = testClass.getDeclaredMethods();

        List<Method> beforeMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                afterMethods.add(method);
            }
        }
        Map<Method, Boolean> testResults = executeMethods(testClass, beforeMethods, testMethods, afterMethods);


        Long totalTests = (long) testResults.size();
        Long passedTests = testResults.entrySet().stream().filter(entry -> entry.getValue().equals(Boolean.TRUE)).count();
        Long failedTests = testResults.entrySet().stream().filter(entry -> entry.getValue().equals(Boolean.FALSE)).count();

        System.out.printf(
                """
                        ========================================================
                        Test results are as follows:
                        Total: %s
                        Passed: %s
                        Failed: %s
                        ========================================================
                        """
                , totalTests, passedTests, failedTests);

        testResults.forEach((test, result) -> {
            if (result.equals(Boolean.FALSE)) {
                System.out.printf("Test %s has failed.\n", test);
            }
        });

        System.out.println("========================================================");
    }

    private Map<Method, Boolean> executeMethods(Class<?> testClass, List<Method> beforeMethods, List<Method> testMethods, List<Method> afterMethods) {

        Map<Method, Boolean> testResults = new HashMap<>();
        for (Method method : testMethods) {

            Object testClassInstance = getTestClassInstance(testClass);
            boolean beforeResult = executeMethods(testClassInstance, beforeMethods);
            if (!beforeResult) {
                testResults.put(method, false);
                continue;
            }

            boolean testResult = executeTest(testClassInstance, method);
            if (!testResult) {
                testResults.put(method, false);
                continue;
            }

            boolean afterResult = executeMethods(testClassInstance, afterMethods);
            if (!afterResult) {
                testResults.put(method, false);
                continue;
            }

            testResults.put(method, true);

        }
        return testResults;
    }

    private Object getTestClassInstance(Class<?> testClass) {
        Object testClassInstance;
        try {
            testClassInstance = testClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return testClassInstance;
    }

    private boolean executeMethods(Object testClassInstance, List<Method> methods) {

        for (Method method : methods) {
            try {
                method.invoke(testClassInstance);
            } catch (Exception e) {
                return false;
            }
        }
        return true;

    }


    private boolean executeTest(Object testClassInstance, Method method) {
        try {
            method.invoke(testClassInstance);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
