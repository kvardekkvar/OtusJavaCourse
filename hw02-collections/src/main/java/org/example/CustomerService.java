package org.example;

import java.util.*;

@SuppressWarnings({"java:S1186", "java:S1135", "java:S1172"}) // при выполнении ДЗ эту аннотацию надо удалить
public class CustomerService {

    // DONE: 3. надо реализовать методы этого класса
    public TreeMap<Customer, String> customerMap = new TreeMap<>();

    private Map.Entry<Customer, String> copyEntry(Map.Entry<Customer, String> actual) {
        return new AbstractMap.SimpleEntry<>(actual.getKey().clone(), actual.getValue());

    }

    public Map.Entry<Customer, String> getSmallest() {
        return copyEntry(customerMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        for (Map.Entry<Customer, String> entry : customerMap.entrySet()) {
            Customer key = entry.getKey();
            if (key.getScores() > customer.getScores()) {
                return copyEntry(entry);
            }
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }
}