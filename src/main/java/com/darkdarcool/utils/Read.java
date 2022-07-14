package com.darkdarcool.utils;

import java.io.IOException;

public class Read {
    public static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();

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
