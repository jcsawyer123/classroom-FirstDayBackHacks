package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.math.BigInteger;

public class ForceRegister extends Command {

    private static String[] commands = {"forceregister"};

    // Usage: !forceregister @id firstname lastname
    public ForceRegister() {
        super("Force Register", "Force Registers a Student", "`!forceregister`", commands, "admin");
    }

    @Override
    public void handleCommand(CommandEvent event) {

        // Check to see if correct number of args
        if(event.getArgs().length < 3){
            event.reply("Please specify: Target ID, First Name and Last Name");
            return;
        }
        // Check if Admin
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("You must me an Admin to run this command.");
            event.reactFailure();
            return;
        }

        // Process Arguments
        String[] args = event.getArgs();
        String firstName = args[1];
        String lastName = args[2];
        String userID = args[0].replaceAll("<@!?(\\d{1,20})>", "$1");

        // Check if valid UID
        long uid;
        try{
            uid = Long.parseLong(userID);
        } catch (NumberFormatException err) {
            event.reply("Invalid ID");
            return;
        }

        // - Add To DB
            // Check they are not already registered
            // Discord ID, First Name, Last Name

        // - Add "Student" role to user
        Role studentRole = null; // TODO: Get from DB
        Member member = event.getGuild().getMemberById(uid);


        event.getGuild()
                .addRoleToMember(member, studentRole)
                .reason("Registered As Student by: "
                        + event.getMember().getUser().getAsTag());
        event.reactSuccess();
    }
}
