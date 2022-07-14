package com.darkdarcool;
import com.darkdarcool.functions.Print;
import com.darkdarcool.utils.Read;

public class Main {
    public static void main(String[] args) {
        CommandLine cmdLine = new CommandLine(args);
        String task = cmdLine.LoadTask();
        if (task == "run") {
            Engine engine = new Engine(Read.getDir(), cmdLine.GetTaskData());
            Registers.register(engine);
            engine.run(Read.readFile("index.js"));
        }
    }
}
