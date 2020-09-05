package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class ForceRegister extends Command {

    private static String[] commands = {"forceregister"};

    // Usage: !forceregister @id firstname lastname
    public ForceRegister() {
        super("Force Regsiter", "Force Registers a Student", "`!forceregister`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
