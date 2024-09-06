package org.example.apiReflection;

public class Concurrentiel {
    public static void main(String[] args) {
        Service service= Service.getInstance();
        Service service2= Service.getInstance();
    }
}
