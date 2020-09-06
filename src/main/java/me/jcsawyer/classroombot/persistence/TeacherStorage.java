package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void addTeacher(Teacher teacher){
        try (Connection connection = source.getConnection();
             PreparedStatement addTeacher = connection.prepareStatement(NEW_TEACHER, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            // Set Values in Statement
            addTeacher.setLong(1, teacher.getDiscordId());
            addTeacher.setString(2, teacher.getFirstname());
            addTeacher.setString(3, teacher.getLastname());
            addTeacher.setString(4, teacher.getTitle());

            // Execute Statement
            addTeacher.executeUpdate();

        } catch (SQLException ex){
            logger.warn("Failed to add teacher", ex);
        }
    }
}
