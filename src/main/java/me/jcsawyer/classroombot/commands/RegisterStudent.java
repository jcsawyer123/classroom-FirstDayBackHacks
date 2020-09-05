package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class RegisterStudent extends Command {

    static String[] commands = {"registerStudent", "Register"};

    // Usage: !registerstudent FirstName LastName
    public RegisterStudent() {
        super("Register Student", "Register Student.", "`!register`, `!registerStudent`", commands, "student");
    }

    @Override
    public void handleCommand(CommandEvent event) {

        // Check to see if correct number of args
        if(event.getArgs().length < 2){
            event.reply("Please specify First Name and Last Name");
            return;
        }

        // Vars
        Member member = event.getMember();
        Role studentRole = null; // Get ID From DB

        String[] args = event.getArgs();
        String firstName = args[0];
        String lastName = args[1];


        // - Add To DB
            // Check they are not already registered
            // Discord ID, First Name, Last Name


        // - Add "Student" role to user
        event.getGuild()
                .addRoleToMember(member, studentRole)
                .reason("Registered As Student by: "
                        + event.getMember().getUser().getAsTag());
        event.reactSuccess();
    }

    @Override
    public boolean requireGuild() {
        return true;
    }


}
