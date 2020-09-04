package me.jcsawyer.classroombot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CommandEvent {

    TextChannel textChannel;
    PrivateChannel privateChannel;

    GuildMessageReceivedEvent guildEvent;
    PrivateMessageReceivedEvent privateMEvent;

    Message message;

    String fullText;
    String command;

    String[] args;
    String fullArg;

    boolean isGuildMessage;

    public CommandEvent(PrivateMessageReceivedEvent event) {
        isGuildMessage = false;
        privateChannel = event.getChannel();
        common(event.getMessage().getContentRaw());
        privateMEvent = event;
        this.message = event.getMessage();
    }

    public CommandEvent(GuildMessageReceivedEvent event) {
        isGuildMessage = true;
        textChannel = event.getChannel();
        common(event.getMessage().getContentRaw());
        this.message = event.getMessage();
        this.guildEvent = event;
    }

    /**
     * Common splits between guild and private messages
     * @param message The message that is common between them
     */
    private void common(String message) {
        String[] a = message.split("\\s+");
        command = a[0];
        args = new String[a.length - 1];
        System.arraycopy(a, 1, args, 0, args.length);
        fullText = message;
        String[] chunks = fullText.split("\\s", 2);
        fullArg = chunks.length == 1 ? "" : chunks[1];
    }

}
