package com.darkdarcool.functions;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;


public class Print implements JavaVoidCallback {
    @Override
    public void invoke(V8Object receiver, V8Array parameters) {
        if (parameters.length() == 0) {
            System.out.println();
            return;
        }
        Object toPrint = parameters.get(0);
        String className = toPrint.getClass().getCanonicalName();
        if (className.equals("com.eclipsesource.v8.V8Object")) {
            System.out.println(parameters.get(0)); // LEARN HOW TO PRETTY PRINT
            return;
        }
        System.out.println(toPrint.toString());



    }
}
