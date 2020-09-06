package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CourseStorage {
    // Setup
    // ----------------
    private static Logger logger = LogManager.getLogger(CourseStorage.class);
    private final HikariDataSource source;

    // Prepared Statements
    // ----------------
    private static final String NEW_COURSE = "INSERT INTO course (short_name, full_name) VALUES (?, ?);";
    private static final String GET_COURSE_BY_ID = "SELECT * FROM course WHERE course_id = ?;";
    private static final String GET_COURSE_BY_CODE = "SELECT * FROM course WHERE short_name = ?;";

    // Constructor
    // ----------------
    public CourseStorage(HikariDataSource source){
        this.source = source;
    }

    // Methods
    // ----------------

}
