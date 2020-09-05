package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;

public class DisenrollStudent extends Command{

    private static String[] commands = {"disneroll"};

    // Removes a Student from a course (Set relation to inactive)
    public DisenrollStudent() {
        super("Disenroll Student", "Disenrolls a student from a course", "`!disroll`", commands, "teacher");
    }

    @Override
    public void handleCommand(CommandEvent event) {
    }
}
