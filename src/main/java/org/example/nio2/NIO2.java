package org.example.nio2;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2 {
    public static void main(String[] args) {
        Path path= Paths.get(URI.create("file:///D:/IXML/PGS/deploy_site.txt"));

        for (Path p: path){
            System.out.println(p.getFileName());
        }
    }
}
