package org.example.threadPratique;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main2 {
    public static void main(String[] args) throws IOException {
        final FileStore fileStore = Files.getFileStore(Path.of("D:\\PROJECT\\codewars-algo\\src\\main\\java\\org\\example\\people.bin"));
        System.out.println(fileStore.getUsableSpace()/1000000000);
    }
}
