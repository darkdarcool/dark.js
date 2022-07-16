package com.darkdarcool.dark.functions.console;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class Error implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        if (parameters.length() == 0) {
            System.err.println();
            return null;
        }
        Object toPrint = parameters.get(0);
        String className = toPrint.getClass().getCanonicalName();
        if (className.equals("com.eclipsesource.v8.V8Object")) {
            System.err.println(parameters.get(0)); // LEARN HOW TO PRETTY PRINT
            return null;
        }
        System.err.println(toPrint.toString());
        return null;
    }
}
