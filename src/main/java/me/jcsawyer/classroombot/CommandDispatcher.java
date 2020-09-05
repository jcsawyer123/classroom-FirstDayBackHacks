package me.jcsawyer.classroombot;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import me.jcsawyer.classroombot.commands.Command;
import net.dv8tion.jda.api.JDA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {

    Logger logger = LogManager.getLogger(CommandDispatcher.class);

    private List<Command> commands;

    public CommandDispatcher() {
        this.commands = new ArrayList<>();

        String pkg = "me.jcsawyer.classroombot.commands";
        try (ScanResult scanResult =
                     new ClassGraph()
                             .enableClassInfo()
                             .whitelistPackages(pkg)
                             .enableAnnotationInfo()
                             .scan()) {
            System.out.println(scanResult.getAllClasses().toString());
            for (ClassInfo routeClassInfo : scanResult.getSubclasses(pkg + ".Command")) {
                System.out.println("Found " + routeClassInfo.toString());
                try {
                    this.commands.add((Command) routeClassInfo.loadClass().getDeclaredConstructor().newInstance());
                    logger.info("Loaded " + routeClassInfo.loadClass().getName());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException | IllegalArgumentException e) {
                    logger.error("Failed to instantiate " + routeClassInfo.loadClass().getName() + ", " + e.getMessage());
                }
            }
        }
    }

    public void onLoad(JDA jda) {
        for (Command c : commands) {
            c.onLoad(jda, this);
        }
    }


}
