package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class RegisterStudent extends Command {

    static String[] commands = {"registerStudent", "Register"};

    // Usage: !registerstudent FirstName LastName
    public RegisterStudent() {
        super("Register Student", "Register Student.", "`!register`, `!registerStudent`", commands, "student");
    }

    @Override
    public void handleCommand(CommandEvent event) {
    }

    @Override
    public boolean requireGuild() {
        return true;
    }


}
