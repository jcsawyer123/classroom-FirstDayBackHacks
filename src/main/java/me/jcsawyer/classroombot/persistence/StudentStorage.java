package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.Student;
import me.jcsawyer.classroombot.entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public void addStudent(Student student){
        try (Connection connection = source.getConnection();
             PreparedStatement addStudent = connection.prepareStatement(NEW_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            // Set Values in Statement
            addStudent.setLong(1, student.getDiscordId());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());

            // Execute Statement
            addStudent.executeUpdate();

        } catch (SQLException ex){
            logger.warn("Failed to add student", ex);
        }
    }

}
