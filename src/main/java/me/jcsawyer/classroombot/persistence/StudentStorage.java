package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentStorage {

    // Setup
    // ----------------
    private static Logger logger = LogManager.getLogger(StudentStorage.class);
    private final HikariDataSource source;

    // Prepared Statements
    // ----------------
    private static final String NEW_STUDENT = "INSERT INTO student (discord_id, first_name, last_name) VALUES (?, ?, ?);";
    private static final String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE student_id = ?;";
    private static final String GET_STUDENT_BY_DISCORD_ID = "SELECT * FROM student WHERE discord_id = ?;";

    // Constructor
    // ----------------
    public StudentStorage(HikariDataSource source){
        this.source = source;
    }

    // Methods
    // ----------------


}
