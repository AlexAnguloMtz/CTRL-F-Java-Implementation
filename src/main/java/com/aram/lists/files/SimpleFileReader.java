package com.aram.lists.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SimpleFileReader {
    public List<String> readLines(String fileName) {
        try {
            return readAllLines(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readAllLines(String fileName) throws IOException {
        return Files.readAllLines(path(fileName));
    }

    private Path path(String fileName) {
        return Paths.get(new File(fileName).toURI());
    }

}