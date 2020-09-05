package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class AddTeacherToCourse extends Command {

    private static String[] commands = {"AddTeacherToCourse", "TeacherAdd", "AddTeacher"};

    public AddTeacherToCourse() {
        super("Add Teacher To Course", "Adds teacher to course", "`!AddTeacherToCourse`, `!TeacherAdd`, `!AddTeacher`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    }

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
