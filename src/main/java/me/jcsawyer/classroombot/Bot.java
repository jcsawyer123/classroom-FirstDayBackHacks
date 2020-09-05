package me.jcsawyer.classroombot;

import me.jcsawyer.classroombot.persistence.Database;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.requests.RateLimiter;
import net.dv8tion.jda.internal.requests.ratelimit.BotRateLimiter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;

public class Bot {

    static String[] emojis = {"✅", "❓", "❌"};
    static Database database = Database.getInstance();

    public static void main(String[] args) throws IOException, LoginException, InterruptedException {
        Configurator.setLevel(BotRateLimiter.class.getName(), Level.TRACE);
        Configurator.setLevel(RateLimiter.class.getName(), Level.TRACE);
        //read the token in
        initBot();
//        new CommandDispatcher();
    }

    private static JDA initBot() throws IOException, LoginException, InterruptedException {
        database.hikariConnect();
        List<String> lines = Files.readAllLines(Paths.get("token.txt"));
        JDA jda = JDABuilder.createDefault(lines.get(0), EnumSet.allOf(GatewayIntent.class))
                .enableCache(EnumSet.allOf(CacheFlag.class))
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL)
                .addEventListeners(new EventManager())
                .build();
        jda.awaitReady();

        return jda;
    }

}
