package com.darkdarcool;

import com.darkdarcool.functions.*;
import com.darkdarcool.functions.console.*;
import com.eclipsesource.v8.*;

public class Registers {
    public static void register(Engine engine) {
        // engine.registerFunction("print", new log());
        // register JavaCallback for require function
        V8Function require = new V8Function(engine.runtime, new Require());
        engine.runtime.add("require", require);

        V8Object module = new V8Object(engine.runtime);
        module.add("exports", new V8Object(engine.runtime));
        engine.runtime.add("module", module);

        V8Object console = new V8Object(engine.runtime);
        console.add("log", new V8Function(engine.runtime, new Log()));
        engine.runtime.add("console", console);
    }
}