package ru.kvardekkvar;

import com.google.common.math.DoubleMath;

public class HelloOtus {
    public static void main(String[] args) {
        boolean isInteger = DoubleMath.isMathematicalInteger(42.0);
        System.out.printf("Guava says it is %s that 42.0 is an integer", isInteger);
        System.out.printf("\nI'm using Java %s", System.getProperty("java.version"));
    }
}
