package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandDispatcher;
import net.dv8tion.jda.api.JDA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCommand extends Command {

    Logger logger = LogManager.getLogger(TestCommand.class);

    @Override
    public void onLoad(JDA jda, CommandDispatcher dispatcher) {
        logger.info("Test command loaded!");
    }
}
