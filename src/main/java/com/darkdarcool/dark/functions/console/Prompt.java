package com.darkdarcool.dark.functions.console;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

import java.util.Scanner;

public class Prompt implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        String defaultMessage = "> ";
        if (parameters.length() > 0 && parameters.getType(0) == V8Value.STRING) {
            defaultMessage = parameters.getString(0);
        }
        System.out.print(defaultMessage);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}