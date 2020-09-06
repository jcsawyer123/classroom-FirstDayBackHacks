package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import me.jcsawyer.classroombot.persistence.Database;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.concurrent.atomic.AtomicReference;

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
            event.reply("Please specify First Name, Last Name");
            return;
        }

        // Vars
        Member member = event.getMember();
        ;

        AtomicReference<Role> studentRole = new AtomicReference<>(event.getGuild().getPublicRole());

        Database.GUILD_DATA.fetchData(event.getGuild().getIdLong(), (data) -> {
            studentRole.set(event.getGuild().getRoleById(data.getStudentRoleId()));
        }, (SQLException) -> {
            System.err.println("error getting data from guild");
        });

        String[] args = event.getArgs();
        String firstName = args[0];
        String lastName = args[1];


        // - Add To DB
            // Check they are not already registered
            // Discord ID, First Name, Last Name

        // Still needs a check of exists
        Database.STUDENT_STORAGE.addStudent(event.getUser().getIdLong(),firstName, lastName);

        // - Add "Student" role to user
        assert member != null;
        event.getGuild()
                .addRoleToMember(member, studentRole.get())
                .reason("Registered As Student by: "
                        + event.getMember().getUser().getAsTag());
        event.reactSuccess();
    }

    @Override
    public boolean requireGuild() {
        return true;
    }


}
