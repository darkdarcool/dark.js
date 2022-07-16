package com.darkdarcool.dark;

import com.darkdarcool.dark.utils.Prettify;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8RuntimeException;

public class Engine {
    public V8 runtime = RuntimeRef.runtime;
    private String dir;
    private String fileName;

    public Engine(String dir, String fileName) {

        runtime.add("__dirname", dir);
        runtime.add("__filename", fileName);

        this.dir = dir;
        this.fileName = fileName;
        // allow strict mode
    }

    public V8 run(String content) {
        try {
            String strictMode = "\"use strict\";\n";
            runtime.executeScript(strictMode + content);
        } catch(V8RuntimeException e) {
            Prettify.prettyPrintError(e, this.dir, this.fileName);
            System.exit(1);
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
