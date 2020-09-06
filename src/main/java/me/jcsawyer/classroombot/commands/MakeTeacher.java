package me.jcsawyer.classroombot.commands;

import com.sun.org.apache.bcel.internal.generic.DADD;
import me.jcsawyer.classroombot.CommandEvent;
import me.jcsawyer.classroombot.persistence.Database;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.concurrent.atomic.AtomicReference;

public class MakeTeacher extends Command {

    static String[] commands = {"maketeacher", "createteacher", "setteacher"};

    // !maketeacher @teacher title firstname lastname
    public MakeTeacher() {
        super("Make Teacher", "Creates a Teacher.", "`!maketeacher`", commands, "admin");
    }

    @Override
    public void handleCommand(CommandEvent event) {

        // Check to see if correct number of args
        if (event.getArgs().length < 4) {
            event.reply("Please specify: Target ID, Title, First Name and Last Name");
            return;
        }
        // Check if Admin
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("You must me an Admin to run this command.");
            event.reactFailure();
            return;
        }

        // Process Arguments
        String[] args = event.getArgs();
        String title = args[1];
        String firstName = args[2];
        String lastName = args[3];
        String userID = args[0].replaceAll("<@!?(\\d{1,20})>", "$1");

        // Check if valid UID
        long uid;
        try {
            uid = Long.parseLong(userID);
        } catch (NumberFormatException err) {
            event.reply("Invalid ID");
            return;
        }

        // - Add To DB
        // Check they are not already registered
        // Discord ID, Title, First Name, Last Name

        // - Add "Student" role to user

        AtomicReference<Role> teacherRole = new AtomicReference<>(event.getGuild().getPublicRole());

        Database.GUILD_DATA.fetchData(event.getGuild().getIdLong(), (data) -> {
            teacherRole.set(event.getGuild().getRoleById(data.getTeacherRoleId()));
        }, (SQLException) -> {
            System.err.println("error getting data from guild");
        }); // TODO: Get from DB
        Member member = event.getGuild().getMemberById(uid);

        // Add teacher to db
        Database.TEACHER_STORAGE.addTeacher(uid,firstName,lastName,title);


        assert member != null;
        event.getGuild()
                .addRoleToMember(member, teacherRole.get())
                .reason("Registered As Teacher by: "
                        + event.getMember().getUser().getAsTag());
        event.reactSuccess();
    }

    @Override
    public boolean requireGuild() {
        return true;
    }
}
