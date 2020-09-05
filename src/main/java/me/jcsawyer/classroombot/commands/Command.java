package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandDispatcher;
import net.dv8tion.jda.api.JDA;

public abstract class Command {

    public void onLoad(JDA jda, CommandDispatcher dispatcher){};

}
