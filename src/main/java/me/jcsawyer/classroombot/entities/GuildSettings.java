package me.jcsawyer.classroombot.entities;

public class GuildSettings {

    long guildId;
    long teacherRoleId;
    long studentRoleId;
    long categoryId;
    String prefix;

    public GuildSettings(long guildId, long teacherRoleId, long studentRoleId, long categoryId, String prefix) {
        this.guildId = guildId;
        this.teacherRoleId = teacherRoleId;
        this.studentRoleId = studentRoleId;
        this.categoryId = categoryId;
        this.prefix = prefix;
    }

    public long getGuildId() {
        return guildId;
    }

    public long getTeacherRoleId() {
        return teacherRoleId;
    }

    public long getStudentRoleId() {
        return studentRoleId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getPrefix() {
        return prefix;
    }
}
