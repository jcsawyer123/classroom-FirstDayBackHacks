package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class ModifyCourse extends Command {

    private static String[] commands = {};

    // Usage:
        // !modify courseCode Option Value
        // !modify courseCode selfenroll true/false
    public ModifyCourse() {
        super("Modify Course", "Modifies course", "`!modifycourse`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
