package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

}
