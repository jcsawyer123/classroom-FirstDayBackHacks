package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;

public class EndSession extends Command {

    private static String[] commands = {};

    // Usage: !endsession courseCode
    public EndSession() {
        super("End Session", "End Course Session", "`!endsession`", commands, "teacher");
        // Perms: Teacher of Course
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
