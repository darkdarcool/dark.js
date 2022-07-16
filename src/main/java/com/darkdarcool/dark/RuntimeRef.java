package com.darkdarcool.dark;

import com.eclipsesource.v8.V8;

import java.util.HashMap;

public class RuntimeRef {
    public static V8 runtime = V8.createV8Runtime();
    public static HashMap<String, Integer> counts = new HashMap<>();
}
