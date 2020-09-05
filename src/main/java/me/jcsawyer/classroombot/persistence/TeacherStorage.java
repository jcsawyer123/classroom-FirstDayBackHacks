package me.jcsawyer.classroombot.persistence;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TeacherStorage {

    private static Logger logger = LogManager.getLogger(TeacherStorage.class);
    private final HikariDataSource source;

    private static final String NEW_TEACHER = "";

    public TeacherStorage(HikariDataSource source){
        this.source = source;
    }



}
