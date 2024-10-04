package com.java.practice.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchDirectory {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
//        Path startPath = Paths.get("./src/main/java/lets_get_certified");
        Path startPath = Paths.get(".\\src\\com\\java\\practice\\io");
        try(var streamPaths = Files.find(startPath, 10, 
                                          (path, attr) -> attr.isRegularFile() 
                                                          && path.toString().endsWith(".java"))){
            streamPaths.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
}
