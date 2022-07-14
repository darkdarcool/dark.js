package com.darkdarcool;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

public class Engine {
    public V8 runtime = RuntimeRef.runtime;
    public Engine(String dir, String fileName) {

        runtime.add("__dirname", dir);
        runtime.add("__filename", fileName);
        // allow strict mode
    }

    public V8 run(String content) {
        try {
            String strictMode = "\"use strict\";\n";
            runtime.executeScript(strictMode + content);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return runtime;
    }

    public void registerFunction(String name, JavaVoidCallback callback) {
        runtime.registerJavaMethod(callback, name);
    }

    public void registerObject(String name, V8Object object) {
        runtime.add(name, object);
    }
}
