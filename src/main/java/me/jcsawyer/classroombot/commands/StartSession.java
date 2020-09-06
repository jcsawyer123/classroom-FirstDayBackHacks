package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import net.dv8tion.jda.api.Permission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StartSession extends Command {

    private static final String[] COMMANDS = {"startsession"};

    public StartSession() {
        super("startsession", "Starts a new session", "{{}}startsession - starts a session", COMMANDS, "admin");


    }

    Logger logger = LogManager.getLogger(TestCommand.class);

    @Override
    public void handleCommand(CommandEvent event) {

        String courseCode = event.getArgs()[0];


        byte[] hash = new byte[0];
        try {
            hash = MessageDigest.getInstance("SHA-1").digest((courseCode + System.currentTimeMillis()).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }

        event.getGuild().createRole().setName(sb.toString()).queue(role -> {
            event.getGuild().createTextChannel(sb.toString()).addPermissionOverride(event.getGuild().getPublicRole(), 0, Permission.MESSAGE_READ.getRawValue()).addPermissionOverride(event.getGuild().getRolesByName((sb.toString()), true).get(0), Permission.MESSAGE_READ.getRawValue(), 0).queue();
            event.getGuild().createVoiceChannel(sb.toString()).addPermissionOverride(event.getGuild().getPublicRole(), 0, Permission.VIEW_CHANNEL.getRawValue()).addPermissionOverride(event.getGuild().getRolesByName(sb.toString(), true).get(0), Permission.VIEW_CHANNEL.getRawValue(), 0).queue();
        });


    }
}
