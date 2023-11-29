package org.example;

import javax.swing.*;

public class ExampleTest {


    @Before
    public void precondition1(){
        System.out.println("Прекондишн поплыл");
    }

    @Test
    public void test01() throws UnsupportedLookAndFeelException {
        System.out.println("Testing tasty testicles... test01");
        throw new UnsupportedLookAndFeelException("Oh no, kebab diarrhea!");
    }
    @Test
    public void test02()  {
        System.out.println("Testing tasty testicles... test02");
    }

    @After
    public void postcondition(){
        System.out.println("Посткондишн поплыл");
    }
}
