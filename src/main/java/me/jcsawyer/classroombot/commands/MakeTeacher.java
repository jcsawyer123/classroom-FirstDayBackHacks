package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import me.jcsawyer.classroombot.commands.Command;
import net.dv8tion.jda.api.Permission;

public class MakeTeacher extends Command{

    static String[] commands = {"maketeacher", "createteacher", "setteacher"};

    public MakeTeacher() {
        super("Make Teacher", "Creates a Teacher.", "`!maketeacher`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    }

    @Override
    public void handleCommand(CommandEvent event) {
    }

    @Override
    public boolean requireGuild() {
        return true;
    }
}
