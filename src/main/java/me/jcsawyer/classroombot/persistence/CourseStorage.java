package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.Course;
import me.jcsawyer.classroombot.entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void addCourse(Course course){
        try (Connection connection = source.getConnection();
             PreparedStatement addCourse = connection.prepareStatement(NEW_COURSE, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            // Set Values in Statement
            addCourse.setString(1, course.getShortName());
            addCourse.setString(2, course.getFullName());

            // Execute Statement
            addCourse.executeUpdate();

        } catch (SQLException ex){
            logger.warn("Failed to add course", ex);
        }
    }
//
//    public Course getCourseByID(Long id){
//        try (Connection connection = source.getConnection();
//             PreparedStatement getCourseById = connection.prepareStatement(GET_COURSE_BY_ID)
//        ) {
//
//            getCourseById.setLong(1, id);
//            ResultSet set = getCourseById.executeQuery();
//
//            // TODO: Return Result
//
////            return result;
//        } catch (SQLException ex){
//            logger.warn("Failed to get Course by ID", ex);
//        }
//    }
}
