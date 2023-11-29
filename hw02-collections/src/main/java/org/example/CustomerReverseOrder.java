package org.example;


import java.util.Stack;

public class CustomerReverseOrder {

    // DONE: 2. надо реализовать методы этого класса
    private final Stack<Customer> collection = new Stack<>();

    public void add(Customer customer) {
        collection.add(customer);
    }

    public Customer take() {
        return collection.pop();
    }
}