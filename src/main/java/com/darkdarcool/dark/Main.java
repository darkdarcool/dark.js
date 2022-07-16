package com.darkdarcool.dark;
import com.darkdarcool.dark.utils.Read;

public class Main {
    public static void main(String[] args) {
        CommandLine cmdLine = new CommandLine(args);
        String task = cmdLine.LoadTask();
        if (task == "run") {
            Engine engine = new Engine(Read.getDir(), cmdLine.GetTaskData());
            Registers.register(engine);
            String fileContent = "";
            try {
                fileContent = Read.readFile(cmdLine.GetTaskData());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("File not found");
            }
            engine.run(fileContent);
        }
    }
}
