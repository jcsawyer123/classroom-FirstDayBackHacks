package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class AddTeacherToCourse extends Command {

    private static String[] commands = {"AddTeacherToCourse", "TeacherAdd", "AddTeacher"};


    // Usage: !teacherAdd @teacher courseCode
    public AddTeacherToCourse() {
        super("Add Teacher To Course", "Adds teacher to course", "`!AddTeacherToCourse`, `!TeacherAdd`, `!AddTeacher`", commands, "admin");
    }

    @Override
    public void handleCommand(CommandEvent event) {

        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify: Target and Course Code ");
            return;
        }
        // Check if Admin
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("You must me an Admin to run this command.");
            event.reactFailure();
            return;
        }

        // TODO: Add record to 'teachers_of_course'
            // Teacher ID
            // Course ID

    }
}
