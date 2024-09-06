package org.example.cefomar;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainCefomar {
    public static void main(String[] args) {
        List<Student> students= Arrays.asList(
                Student.builder().name("Rakoto").dateOfBirth(new Date()).formation("Securité de base").number("SB-112").build(),
                Student.builder().name("Randria").dateOfBirth(new Date()).formation("Securité de base").number("SB-113").build(),
                Student.builder().name("Rasoa").dateOfBirth(new Date()).formation("Sûreté de base").number("SR-101").build(),
                Student.builder().name("Rabe").dateOfBirth(new Date()).formation("Initiation maritime").number("IM-100").build(),
                Student.builder().name("Fatakamana").dateOfBirth(new Date()).formation("Initiation maritime").number("IM-101").build()
        );

        List<Formation> formations= Arrays.asList(
                Formation.builder().name("Initiation maritime").ref("IM").coast(410000L).duration(14)
                        .students( Arrays.asList(
                                        Student.builder().name("Rabe").dateOfBirth(new Date()).number("IM-100").build(),
                                        Student.builder().name("Fatakamana").dateOfBirth(new Date()).number("IM-101").build()
                                )).build(),
                Formation.builder().name("Sécurité de base").ref("SB").coast(650000L).duration(14)
                        .students( Arrays.asList(
                                Student.builder().name("Rakoto").dateOfBirth(new Date()).number("SB-112").build(),
                                Student.builder().name("Randria").dateOfBirth(new Date()).number("SB-113").build()
                        )).build(),
                Formation.builder().name("Sûreté de base").ref("SR").coast(250000L).duration(4)
                        .students( Arrays.asList(
                                Student.builder().name("Rasoa").dateOfBirth(new Date()).number("SR-101").build()
                        )).build()

        );
/*
        try (FileOutputStream fos= new FileOutputStream("D://cefomar/formation.bin");
            FilesOutputFormation filesOutputFormation= new FilesOutputFormation(fos);
            ){

            filesOutputFormation.writeFields(formations);
            System.out.println("written formations files Done!!!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
*/

        try (FileInputStream inputStream= new FileInputStream("D://cefomar/formation.bin");
             FilesInputFormation filesInputFormation= new FilesInputFormation(inputStream)) {

            filesInputFormation.readFields()
                    .forEach(formation -> {
                        System.out.println(formation.toString());
                    });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
