package me.jcsawyer.classroombot;

import net.dv8tion.jda.api.EmbedBuilder;
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


    /**
     * Get the JDA instance
     *
     * @return the JDA instance associated with this bot.
     */
    @Nonnull
    public JDA getJDA() {
        return message.getJDA();
    }

    /**
     * Gets the text channel associated with this event.  Will throw iff run from a DM.
     *
     * @return the TextChannel from which this command was invoked
     * @throws IllegalStateException iff this command was not run from a guild
     */
    @Nonnull
    public TextChannel getTextChannel() {
        if (!isGuildMessage()) throw new IllegalStateException("Not a guild channel.");
        return textChannel;
    }

    /**
     * Gets the private channel associated with this event.  Will throw iff run from a guild.
     *
     * @return the PrivateChannel from which this command was run
     * @throws IllegalStateException iff the command was run from a guild
     */
    @Nonnull
    public PrivateChannel getPrivateChannel() {
        if (isGuildMessage()) throw new IllegalStateException("Not a private channel.");
        return privateChannel;
    }

    /**
     * Get the {@link MessageChannel} this was sent in.
     *
     * @return the text or private channel, depending on the context.
     */
    @Nonnull
    public MessageChannel getMessageChannel() {
        return isGuildMessage ? textChannel : privateChannel;
    }

    /**
     * Gets the raw GuildMessageReceivedEvent. Will throw iff run from a DM
     *
     * @return the raw GuildMessageReceivedEvent.
     * @throws IllegalStateException iff the command was not run from a guild
     */
    @Nonnull
    public GuildMessageReceivedEvent getGuildEvent() {
        if (!isGuildMessage()) throw new IllegalStateException("Not a guild message.");
        return guildEvent;
    }

    /**
     * Gets the raw PrivateMessageReceivedEvent. Will throw iff run from a guild
     *
     * @return the raw PrivateMessageReceivedEvent.
     * @throws IllegalStateException iff run from a guild.
     */
    @Nonnull
    public PrivateMessageReceivedEvent getPrivateMEvent() {
        if (isGuildMessage()) throw new IllegalStateException("Not a private message");
        return privateMEvent;
    }

    /**
     * Gets the Message object from which this command was invoked (ie, the user input)
     *
     * @return the Message object
     */
    @Nonnull
    public Message getMessage() {
        return message;
    }

    /**
     * Gets the full String content of the message.
     *
     * @return the full command String, including the prefix and command.
     */
    @Nonnull
    public String getFullText() {
        return fullText;
    }

    /**
     * Gets the arguments provided to this command. May be empty if no arguments specified.
     * Does not include the prefix or command.
     *
     * @return the array of arguments
     */
    @Nonnull
    public String[] getArgs() {
        return args;
    }

    /**
     * Gets the command slug used for this command.
     * Returns only the command - no prefix or arguments.
     *
     * @return the string used to run this command.
     */
    @Nonnull
    public String getCommand() {
        return command;
    }

    /**
     * Returns true if this command was invoked from a guild
     *
     * @return true if from a guild; else false.
     */
    public boolean isGuildMessage() {
        return isGuildMessage;
    }

    /**
     * Gets the {@link Guild} from which this command was run.
     * Can be null if not run from a guild
     *
     * @return the guild this event was run from, null if not run from a guild
     */
    @Nonnull
    public Guild getGuild() {
        if (!isGuildMessage()) throw new IllegalStateException("Not run from a guild");
        return guildEvent.getGuild();
    }

    /**
     * Gets the {@link User} who ran this command
     *
     * @return The user who ran this command.
     */
    @Nonnull
    public User getUser() {
        return isGuildMessage ? guildEvent.getAuthor() : privateMEvent.getAuthor();
    }

    /**
     * Gets the {@link User} who ran this command.
     * The same as {@link CommandEvent#getUser()}
     *
     * @return the user who ran this command.
     */
    @Nonnull
    public User getAuthor() {
        return getUser();
    }

    /**
     * Gets the {@link Member} who ran this command.
     * Can be null if not run from a {@link Guild}
     *
     * @return the member who ran this command; null if not from a guild.
     */
    @Nullable
    public Member getMember() {
        return guildEvent.getMember();
    }

    /**
     * Gets the {@link MessageChannel} that the command was sent in
     *
     * @return Non-null message channel
     */
    @Nonnull
    public MessageChannel getChannel() {
        return isGuildMessage ? textChannel : privateChannel;
    }

    /**
     * Gets the bot as a member of the guild from which this command was run
     * @return the Bot, as a Member.
     * @throws IllegalStateException iff the event is not a guild event
     */
    @Nonnull
    public Member getSelfMember(){
        if (!isGuildMessage()) throw new IllegalStateException("Not a guild event.");
        return guildEvent.getGuild().getSelfMember();
    }


    /**
     * Sends a Message to the origin channel, as an Embed.
     * @param title The title of the embed
     * @param description the description of the embed
     * @param colour the colour of the embed
     * @param fields varargs (optional) of any additional fields in the embed.
     */
    public void sendEmbed(String title, String description, int colour, MessageEmbed.Field... fields){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setDescription(description);
        eb.setTitle(title);
        eb.setColor(colour);
        for (MessageEmbed.Field f : fields){
            eb.addField(f);
        }
        this.getChannel().sendMessage(eb.build()).queue();
    }

}
