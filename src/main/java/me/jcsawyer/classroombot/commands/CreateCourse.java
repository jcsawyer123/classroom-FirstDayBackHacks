package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class CreateCourse extends Command{

    private static String[] commands = {"createcourse", "coursecreate"};

    public CreateCourse() {
        super("Create Course", "Creates a course", "`!createcourse`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    };

    @Override
    public void handleCommand(CommandEvent event) {

    }
}
