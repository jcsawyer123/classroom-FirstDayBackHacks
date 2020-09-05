package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;

public class EnrollStudent extends Command {

    private static String[] commands = {"enroll"};

    // Teacher can enroll student
    public EnrollStudent(){
        super("Enroll Student", "Enrolls a student into a course", "`!enroll`", commands, "teacher");
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
