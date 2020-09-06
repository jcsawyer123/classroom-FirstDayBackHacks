package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.Session;
import me.jcsawyer.classroombot.entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionStorage {
    // Setup
    // ----------------
    private static Logger logger = LogManager.getLogger(SessionStorage.class);
    private final HikariDataSource source;

    // Prepared Statements
    // ----------------
    private static final String NEW_SESSION = "INSERT INTO session (date_started, date_ended, txt_channel_id, voice_channel_id, register_id, max_attendance) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String GET_SESSION_BY_ID = "SELECT * FROM session WHERE session_id = ?;";

    // Constructor
    // ----------------
    public SessionStorage(HikariDataSource source){
        this.source = source;
    }

    // Methods
    // ----------------
    public void addSession(Session session){
        try (Connection connection = source.getConnection();
             PreparedStatement addSession = connection.prepareStatement(NEW_SESSION, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            // Set Values in Statement
            addSession.setDate(1, session.getDateStarted());
            addSession.setDate(2, session.getDateEnded());
            addSession.setLong(3, session.getTextChannelId());
            addSession.setLong(4, session.getVoiceChannelId());
            addSession.setLong(5, session.getRegisterId());
            addSession.setInt(6, session.getMaxAttendance());

            // Execute Statement
            addSession.executeUpdate();

        } catch (SQLException ex){
            logger.warn("Failed to add session", ex);
        }
    }

}
