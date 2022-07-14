package com.darkdarcool.functions;

import com.darkdarcool.Engine;
import com.darkdarcool.Registers;
import com.darkdarcool.RuntimeRef;
import com.darkdarcool.utils.Read;
import com.eclipsesource.v8.*;
import com.eclipsesource.v8.utils.V8ObjectUtils;

import java.io.File;

public class Require implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        String dir = receiver.get("__dirname").toString();
        String fileName = parameters.get(0).toString();
        String fullFilePath = dir + "\\" + fileName;
        Engine engine = new Engine(reloadDirectoryPath(fullFilePath), fileName);
        Registers.register(engine);
        String fileContent;
        try {
            fileContent = Read.readFile(fullFilePath);
        } catch (Exception e) {
            System.out.println("Requested file " + fullFilePath + " was not found. Also lets make an error for this later ngl");
            System.exit(0);
            return null;
        }
        V8 data = engine.run(fileContent);
        V8Object module = data.getObject("module");
        Object exports;
        int type = module.getType("exports");
        if (type == V8Value.V8_OBJECT) {
            exports = module.getObject("exports");
            return exports;
        }
        exports = module.get("exports");
        module.release();
        return exports;
    }
    private String reloadDirectoryPath(String fullPath) {
        File file = new File(fullPath);
        String dir = file.getParent();
        return dir;
    }
}
