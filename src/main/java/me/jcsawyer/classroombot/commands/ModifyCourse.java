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

        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify: Course Code, Option, Value");
            return;
        }
        // Check if Admin
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("You must me an Admin to run this command.");
            event.reactFailure();
            return;
        }

        // TODO: Update record in 'course'
        // opt_self_enrol
        // value
    }
}
