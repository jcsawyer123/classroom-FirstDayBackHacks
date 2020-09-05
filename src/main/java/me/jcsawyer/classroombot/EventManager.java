package me.jcsawyer.classroombot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.annotation.Nonnull;

public class EventManager implements EventListener{

    CommandDispatcher dispatcher;

    EventManager(){
        this.dispatcher = new CommandDispatcher();
    }

    @Override
    public void onEvent(@Nonnull GenericEvent event) {
        if (event instanceof ReadyEvent){
            System.out.println("Ready!");
            dispatcher.onLoad(event.getJDA());
        }
        if (event instanceof GuildMessageReceivedEvent){

        }
    }
}
