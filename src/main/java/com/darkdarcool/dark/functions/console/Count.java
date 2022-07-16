package com.darkdarcool.dark.functions.console;

import com.darkdarcool.dark.RuntimeRef;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

import java.util.HashMap;

public class Count implements JavaCallback {
    private HashMap<String, Integer> counts = RuntimeRef.counts;
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        String key = "default";
        if (parameters.length() != 0) {
            key = parameters.getString(0);
        }
        if (counts.containsKey(key)) {
            counts.put(key, counts.get(key) + 1);
        } else {
            counts.put(key, 1);
        }
        System.out.println(key + ": " + counts.get(key));
        return null;
    }
}
