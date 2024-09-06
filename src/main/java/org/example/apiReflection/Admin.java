package org.example.apiReflection;

import lombok.Data;

public class Admin extends User{
    private String password;

    public Admin(String name, int age){
        super(name, age);
    }
    public Admin(String name, int age,String password){
        super(name, age);
        this.password= password;
    }
    public String hashPassword(String hash){
        StringBuilder hashFinal= new StringBuilder();

        if(hash.equals("sha255")){
            for(char c: password.toCharArray()){
                hashFinal.append(String.valueOf(c +""+ (int) c));
            }
            return hashFinal.toString();
        }
        return "";
    }
    public String getPassword(){
        return this.password;
    }
}
