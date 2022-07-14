package com.darkdarcool.functions;

import com.darkdarcool.Engine;
import com.darkdarcool.Registers;
import com.darkdarcool.RuntimeRef;
import com.darkdarcool.utils.Read;
import com.eclipsesource.v8.*;
import com.eclipsesource.v8.utils.V8ObjectUtils;

public class Require implements JavaCallback {
    @Override
    public Object invoke(V8Object receiver, V8Array parameters) {
        String dir = receiver.get("__dirname").toString();
        String fileName = parameters.get(0).toString();
        String fullFilePath = dir + "\\" + fileName;
        Engine engine = new Engine(reloadDirectoryPath(fullFilePath), fileName);
        Registers.register(engine);
        V8 data = engine.run(Read.readFile(fullFilePath));
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
        String[] split = fullPath.split("\\\\");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i]);
            sb.append("\\");
        }
        return sb.toString();
    }
}
