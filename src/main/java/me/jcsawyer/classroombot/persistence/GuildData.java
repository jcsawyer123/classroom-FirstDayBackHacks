package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.GuildSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class GuildData {

    Logger logger = LogManager.getLogger(GuildData.class);

    HikariDataSource source;

    static String SET_GUILD_DATA =
            "insert into guild_table(guild_id, teacher_role_id, student_role_id, category_id, prefix) VALUES (?, ?, ?, ?, ?);";
    static String GET_GUILD_DATA =
            "select teacher_role_id, student_role_id, category_id, prefix from guild_table where guild_id = ?;";

    public GuildData(HikariDataSource source){
        this.source = source;
    }

    public void fetchData(long guildID, Consumer<GuildSettings> success, Consumer<SQLException> failure){
        fetchData(Database.dbPool, guildID, success, failure);
    }

    public void setData(long guildID, GuildSettings data, Runnable success, Consumer<SQLException> failure) {
        setPrefix(Database.dbPool, guildID, data, success, failure);
    }


    private void setPrefix(ExecutorService exec, long guildID, GuildSettings data, Runnable success, Consumer<SQLException> failure) {
        exec.submit(
                () -> {
                    try (Connection connection = source.getConnection();
                         PreparedStatement setGuildData = connection.prepareStatement(SET_GUILD_DATA);
                    ){

                        setGuildData.setLong(1, guildID);
                        setGuildData.setLong(2, data.getTeacherRoleId());
                        setGuildData.setLong(3, data.getStudentRoleId());
                        setGuildData.setLong(4, data.getCategoryId());
                        setGuildData.setString(5, data.getPrefix());

                        setGuildData.execute();

                        if (success != null) success.run();

                    } catch (SQLException ex) {
                        logger.warn("Committing to the database failed - ", ex);
                        if (failure != null) failure.accept(ex);
                    }
                }
        );
    }

    private void fetchData(ExecutorService exec, long guildID, Consumer<GuildSettings> success, Consumer<SQLException> failure) {
        exec.submit(
                () -> {
                    try (Connection connection = source.getConnection();
                         PreparedStatement getGuildData = connection.prepareStatement(GET_GUILD_DATA);
                    ) {

                        getGuildData.setLong(1, guildID); //the guildid to fetch

                        getGuildData.executeQuery();

                        try (ResultSet set = getGuildData.getResultSet()){

                            if (set == null || !set.next()) {
                                success.accept(null);
                                return;
                            }

                            GuildSettings settings = new GuildSettings(guildID,
                                    set.getLong("teacher_role_id"),
                                    set.getLong("student_role_id"),
                                    set.getLong("category_id"),
                                    set.getString("prefix"));

                            success.accept(settings);
                        }


                    } catch (SQLException ex) {
                        logger.warn("Failed to fetch guild prefix from the database - ", ex);
                        failure.accept(ex);
                    }
                });
    }

}
