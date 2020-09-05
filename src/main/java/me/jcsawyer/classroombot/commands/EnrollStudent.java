package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;

public class EnrollStudent extends Command {

    private static String[] commands = {"enroll"};

    // Usage: !enroll @id coursecode
    public EnrollStudent(){
        super("Enroll Student", "Enrolls a student into a course", "`!enroll`", commands, "teacher");
    }

    // Teacher can enroll student
    @Override
    public void handleCommand(CommandEvent event) {

    }
}
