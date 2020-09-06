package me.jcsawyer.classroombot.entities;

import javax.annotation.Nullable;
import java.sql.Date;
import java.time.OffsetDateTime;
import java.util.List;

public class Session {

    private OffsetDateTime dateStarted;
    private OffsetDateTime dateEnded;
    private final long textChannelId;
    private final long voiceChannelId;
    private final long registerId;
    private final long roleId;
    private final int maxAttendance;
    private List<Course> courses;
    private List<Student> students;


    public Session(OffsetDateTime dateStarted, OffsetDateTime dateEnded, long textChannelId, long voiceChannelId, long registerId, long roleId, int maxAttendance, List<Course> courses, List<Student> students) {
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.textChannelId = textChannelId;
        this.voiceChannelId = voiceChannelId;
        this.registerId = registerId;
        this.roleId = roleId;
        this.maxAttendance = maxAttendance;
        this.courses = courses;
        this.students = students;
    }

    public Session(OffsetDateTime dateStarted, long textChannelId, long voiceChannelId, long registerId, long roleId, int maxAttendance, List<Course> courses, List<Student> students) {
        this.dateStarted = dateStarted;
        this.textChannelId = textChannelId;
        this.voiceChannelId = voiceChannelId;
        this.registerId = registerId;
        this.roleId = roleId;
        this.maxAttendance = maxAttendance;
        this.courses = courses;
        this.students = students;
    }

    public void setDateStarted(OffsetDateTime dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateEnded(OffsetDateTime dateEnded) {
        this.dateEnded = dateEnded;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    @Nullable
    public Date getDateEnded() {
        return dateEnded;
    }

    public long getTextChannelId() {
        return textChannelId;
    }

    public long getVoiceChannelId() {
        return voiceChannelId;
    }

    public long getRegisterId() {
        return registerId;
    }

    public long getRoleId() {
        return roleId;
    }

    public int getMaxAttendance() {
        return maxAttendance;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

}
