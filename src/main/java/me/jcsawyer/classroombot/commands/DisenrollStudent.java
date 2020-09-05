package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class DisenrollStudent extends Command{

    private static String[] commands = {"disneroll"};

    // Usage: !disneroll @id courseCode
    public DisenrollStudent() {
        super("Disenroll Student", "Disenrolls a student from a course", "`!disenroll`", commands, "teacher");
    }

    // Removes a Student from a course (Set relation to inactive)
    @Override
    public void handleCommand(CommandEvent event) {
        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify: Target and Course Code ");
            return;
        }
        // Check if Teacher+
        // TODO: Get ID for Teacher Role for check
//        if(!event.getMember().getRoles().contains(/* TODO: Check if Teacher*/) && !event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
//            event.reply("You must me a Teacher to run this command.");
//            event.reactFailure();
//            return;
//        }

        // TODO: Check if user is enrolled
//        if(/* User is enrolled in course */) {
//            event.reply("User is not enrolled");
//            event.reactFailure();
//            return;
//        }

        // TODO: Update record of 'teachers_of_course'
        // Active = False
    }
}
