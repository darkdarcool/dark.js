package com.darkdarcool;

public class CommandLine {
    private String[] args;
    private String taskData;
    public CommandLine(String[] args) {
        this.args = args;
    }
    public String LoadTask() {
        if (args.length == 0) {
            System.out.println("No file specified"); // TODO: Help message
            System.exit(0);
        }
        else if (args[0].equals("run")) {
            if (args.length == 1) {
                System.out.println("No file specified"); // TODO: Help message
                System.exit(0);
            } else {
                taskData = args[1];
                return "run";
            }
        }
        else {
            System.out.println("Unknown command " + args[0]);
            System.exit(0);
        }
        return "";
    }
    public String GetTaskData() {
        return taskData;
    }
}
