package com.darkdarcool.dark.functions.console;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class Clear implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        // clear console
        System.out.print("\033[H\033[2J");
        return null;
    }
}