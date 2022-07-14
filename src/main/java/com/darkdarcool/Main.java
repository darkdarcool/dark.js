package com.darkdarcool;
import com.darkdarcool.utils.Read;

public class Main {
    public static void main(String[] args) {
        CommandLine cmdLine = new CommandLine(args);
        String task = cmdLine.LoadTask();
        if (task == "run") {
            Engine engine = new Engine(Read.getDir(), cmdLine.GetTaskData());
            Registers.register(engine);
            String fileContent = "";
            try {
                fileContent = Read.readFile(Read.getFullFilePath(cmdLine.GetTaskData()));
            } catch (Exception e) {
                System.out.println("File not found");
            }
            engine.run(fileContent);
        }
    }
}
