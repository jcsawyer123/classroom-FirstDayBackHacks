package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class CreateCourse extends Command{

    private static String[] commands = {"createcourse", "coursecreate"};


    // Usage: !createcourse courseCode courseName
        // e.g. !courseCreate CS420 Introduction to Discord Bot
    public CreateCourse() {
        super("Create Course", "Creates a course", "`!createcourse`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    };

    @Override
    public void handleCommand(CommandEvent event) {
        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify: Course Code, Course Name");
            return;
        }
        // Check if Admin
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("You must me an Admin to run this command.");
            event.reactFailure();
            return;
        }

        // TODO: Add record to 'courses'
        // Short Name
        // Long Name
        // Self Enroll (Default: False)


    }
}
