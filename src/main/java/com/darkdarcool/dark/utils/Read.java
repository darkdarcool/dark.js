package com.darkdarcool.dark.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Read {
    public static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        try (Stream linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(sb::append);
        }

        return sb.toString();
    }

    public static String getFullFilePath(String fileName) {
        String path = System.getProperty("user.dir");
        return path + "\\" + fileName;
    }

    public static String getDir() {
        String path = System.getProperty("user.dir");
        return path;
    }
}
