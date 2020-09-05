package me.jcsawyer.classroombot.entities;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;

public class Session {

    private OffsetDateTime dateStarted;
    private OffsetDateTime dateEnded;
    private final long textChannelId;
    private final long voiceChannelId;
    private final long refisterId;
    private final long roleId;
    private final int maxAttendance;
    private List<Course> courses;
    private List<Student> students;


    public Session(OffsetDateTime dateStarted, OffsetDateTime dateEnded, long textChannelId, long voiceChannelId, long refisterId, long roleId, int maxAttendance, List<Course> courses, List<Student> students) {
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.textChannelId = textChannelId;
        this.voiceChannelId = voiceChannelId;
        this.refisterId = refisterId;
        this.roleId = roleId;
        this.maxAttendance = maxAttendance;
        this.courses = courses;
        this.students = students;
    }

    public Session(OffsetDateTime dateStarted, long textChannelId, long voiceChannelId, long refisterId, long roleId, int maxAttendance, List<Course> courses, List<Student> students) {
        this.dateStarted = dateStarted;
        this.textChannelId = textChannelId;
        this.voiceChannelId = voiceChannelId;
        this.refisterId = refisterId;
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

    public OffsetDateTime getDateStarted() {
        return dateStarted;
    }

    @Nullable
    public OffsetDateTime getDateEnded() {
        return dateEnded;
    }

    public long getTextChannelId() {
        return textChannelId;
    }

    public long getVoiceChannelId() {
        return voiceChannelId;
    }

    public long getRefisterId() {
        return refisterId;
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
