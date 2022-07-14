package com.darkdarcool.utils;

public class Read {
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
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
