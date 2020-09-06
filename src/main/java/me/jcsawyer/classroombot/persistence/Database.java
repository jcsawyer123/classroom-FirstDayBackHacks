package me.jcsawyer.classroombot.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.jcsawyer.classroombot.entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Database {

    private static Database instance = null;
    private static Logger logger = LogManager.getLogger(Database.class);
    private static final int SQL_ATTEMPTS = 3;
    static ExecutorService dbPool = Executors.newFixedThreadPool(4);

    private HikariDataSource source;

    public static TeacherStorage TEACHER_STORAGE;
    public static GuildData GUILD_DATA;
    public static SessionStorage SESSION_STORAGE;
    public static StudentStorage STUDENT_STORAGE;
    public static CourseStorage COURSE_STORAGE;

    public static Database getInstance(){
        if (instance == null){
            return new Database();
        } else {
            return instance;
        }
    }

    private Database(){
        instance = this;
        try {
            hikariConnect();
        } catch (IOException ex){
            logger.error("Database connection failed.");
        }
    }

    public void hikariConnect() throws IOException {
        ObjectMapper om = new ObjectMapper();
        HikariConfig config = new HikariConfig();
        HashMap<?, ?> configData = om.readValue(new File("database.json"), HashMap.class);
        logger.info(configData.toString());
        config.setJdbcUrl((String) configData.get("url")); //"jdbc:postgresql://localhost/classroombot?tcpKeepAlive=true"
        config.setUsername((String) configData.get("username")); //classroombot
        config.setPassword((String) configData.get("password"));
        config.setSchema((String) configData.get("schema")); //public
        config.setMaximumPoolSize(10);

        source = new HikariDataSource(config);

        TEACHER_STORAGE = new TeacherStorage(source);
        STUDENT_STORAGE = new StudentStorage(source);
        SESSION_STORAGE = new SessionStorage(source);
        COURSE_STORAGE = new CourseStorage(source);
        GUILD_DATA = new GuildData(source);

    }

}
