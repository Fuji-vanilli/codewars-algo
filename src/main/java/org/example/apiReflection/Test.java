package org.example.apiReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> c= Class.forName("org.example.apiReflection.Admin");
        Constructor<?> constructor= c.getConstructor(String.class, int.class, String.class);
        Admin admin= (Admin) constructor.newInstance("rakoto", 28, "xendercage214");

        Method hashPassword= c.getMethod("hashPassword", String.class);
        Method getName= c.getMethod("getName");

        Field password= c.getDeclaredField("password");
     //   Field name= c.getField("name");

        password.setAccessible(true);
     //   name.setAccessible(true);
/*
        password.set(admin, "xendercage214");
        name.set(admin, "root");
*/

        String hash= (String) hashPassword.invoke(admin, "sha255");
        String nameAdmin= (String) getName.invoke(admin);

        System.out.println(hash);
        System.out.println(nameAdmin);

        int mod= getName.getModifiers();

        System.out.println(Modifier.isPublic(mod));



    }
}
