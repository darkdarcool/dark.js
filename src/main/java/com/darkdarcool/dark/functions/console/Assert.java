package com.darkdarcool.dark.functions.console;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

public class Assert implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        if (parameters.length() >= 2) {
            boolean condition = true;
            if (parameters.getType(0) != V8Value.BOOLEAN) {
                System.out.println("Assertion failed: " + parameters.get(0) + " is not a boolean");
            } else condition = parameters.getBoolean(0);
            if (!condition) {
                System.out.println("Assertion failed: " + parameters.get(1));
            }
        }
        return null;
    }
}