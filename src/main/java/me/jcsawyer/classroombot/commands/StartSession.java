package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;

public class StartSession extends Command {

    private static String[] commands = {};

    // Usage: !startsession courseCode
    public StartSession() {
        super("Start Session", "Starts Course Session", "`!startsession`", commands, "teacher");
        // Perms: Teacher of Course
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
