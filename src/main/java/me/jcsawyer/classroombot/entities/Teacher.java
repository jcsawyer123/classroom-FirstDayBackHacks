package me.jcsawyer.classroombot.entities;

import java.util.List;

public class Teacher {

    private final long discordId;
    private String firstname;
    private String lastname;
    private String title;
    private List<Course> courses;

    public Teacher(long discordId, String firstname, String lastname, String title) throws IllegalArgumentException {
        if (firstname.length() > 256) {
            throw new IllegalArgumentException("Firstname must be less that 256 characters");
        }
        if (lastname.length() > 256) {
            throw new IllegalArgumentException("Lastname must be less that 256 characters");
        }
        if (title.length() > 32) {
            throw new IllegalArgumentException("Title must be less than 32 characters");
        }
        this.discordId = discordId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.courses = null;
    }

    public Teacher(long discordId, String firstname, String lastname, String title, List<Course> courses) throws IllegalArgumentException {
        if (firstname.length() > 256) {
            throw new IllegalArgumentException("Firstname must be less that 256 characters");
        }
        if (lastname.length() > 256) {
            throw new IllegalArgumentException("Lastname must be less that 256 characters");
        }
        if (title.length() > 32) {
            throw new IllegalArgumentException("Title must be less than 32 characters");
        }
        this.discordId = discordId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.courses = courses;
    }

    public long getDiscordId() {
        return discordId;
    }

    public String getFirstname() {
        return firstname;
    }

    public List<Course> getCourses() {
        return courses;
    }


    public String getTitle() {
        return title;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return title + " " + firstname + " " + lastname;
    }

    public void setFirstname(String firstname) throws IllegalArgumentException {
        if (firstname.length() > 256) {
            throw new IllegalArgumentException("Firstname must be less that 256 characters");
        }
        this.firstname = firstname;
    }

    public void setLastname(String lastname) throws IllegalArgumentException {
        if (lastname.length() > 256) {
            throw new IllegalArgumentException("Lastname must be less that 256 characters");
        }
        this.lastname = lastname;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.length() > 32) {
            throw new IllegalArgumentException("Title must be less than 32 characters");
        }
        this.title = title;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}
