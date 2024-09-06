package org.example.apiReflection;

public class Service {
    public static Service service;

    private Service(){}

    public static Service getInstance(){
        if(service!= null){
            service= new Service();
            return service;
        }
        return null;
    }
}
