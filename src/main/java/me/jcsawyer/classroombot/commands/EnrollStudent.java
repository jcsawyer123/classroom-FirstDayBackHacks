package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class EnrollStudent extends Command {

    private static String[] commands = {"enroll"};

    // Usage: !enroll @id coursecode
    public EnrollStudent(){
        super("Enroll Student", "Enrolls a student into a course", "`!enroll`", commands, "teacher");
    }

    // Teacher can enroll student
    @Override
    public void handleCommand(CommandEvent event) {
        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify: Target, Course Code ");
            return;
        }
        // Check if Teacher+
        // TODO: Get ID for Teacher Role for check
//        if(!event.getMember().getRoles().contains(/* TODO: Check if Teacher*/) && !event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
//            event.reply("You must me a Teacher to run this command.");
//            event.reactFailure();
//            return;
//        }

        // TODO: Add record to 'students_of_course'
        // Student ID
        // Course ID
    }
}
