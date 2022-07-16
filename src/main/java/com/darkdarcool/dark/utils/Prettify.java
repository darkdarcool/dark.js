package com.darkdarcool.dark.utils;

import com.eclipsesource.v8.V8RuntimeException;

public class Prettify {
    public static void prettyPrintError(V8RuntimeException error, String dir, String fileName) {
        System.out.println(trimError(error.getMessage()));
        System.out.println("In file: " + dir + "\\" + fileName + ":" + getErrorLine(error.getMessage()));
    }

    private static String trimErrorMessage(String message) {
        return message.substring(message.indexOf(':') + 2).substring(2); // lol what is this i don't even know
    }

    private static String getErrorLine(String message) {
        return Integer.toString(Integer.parseInt(message.split(":")[1]) - 1); // also what the hell is this
    }

    private static String trimErrorToType(String message) {
        return message.split(":")[0];
    }

    private static String trimErrorToReason(String message) {
        return message.split(":")[1];
    }

    private static String trimError(String message) {
        message = trimErrorMessage(message);
        String type = trimErrorToType(message);
        String reason = trimErrorToReason(message);
        return Colors.yellow + type + Colors.reset + ":" + Colors.red + reason + Colors.reset;
    }
}
