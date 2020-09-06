package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TeacherStorage {

    // Setup
    // ----------------
    private static Logger logger = LogManager.getLogger(TeacherStorage.class);
    private final HikariDataSource source;

    // Prepared Statements
    // ----------------
    private static final String NEW_TEACHER = "INSERT INTO teacher (discord_id, first_name, last_name, title) VALUES (?, ?, ?, ?);";
    private static final String GET_TEACHER_BY_ID = "SELECT * FROM teacher where teacher_id = ?;";
    private static final String GET_TEACHER_BY_DISCORD_ID = "SELECT * FROM teacher where discord_id = ?;";


    // Constructor
    // ----------------
    public TeacherStorage(HikariDataSource source){
        this.source = source;
    }

    // Methods
    // ----------------

}
