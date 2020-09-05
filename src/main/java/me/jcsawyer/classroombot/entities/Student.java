package me.jcsawyer.classroombot.entities;

import javax.annotation.Nullable;
import java.util.List;

public class Student {
  private int studentId;
  private long discordId;
  private String firstName;
  private String lastName;
  
  private List<Course> courses = null;
  
  public Student(int studentId, long discordId, String firstName, String lastName, List<Course> courses)
    throws IllegalArgumentException {
    new Student(studentId, discordId, firstName, lastName);
    this.courses = courses;
  }
  
  public Student(int studentId, long discordId, String firstName, String lastName)
    throws IllegalArgumentException {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Firstname is longer than 256 characters.");
    } else if(lastName.length() > 256) {
      throw new IllegalArgumentException("Lastname is longer than 256 characters.");
    }
    this.studentId = studentId;
    this.discordId = discordId;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  @Nullable
  public List<Course> getCourses() {
    return courses;
  }
  
  public void setCourses(@Nullable List<Course> courses) {
    this.courses = courses;
  }
  
  public int getStudentId() {
    return studentId;
  }
  
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
  
  public long getDiscordId() {
    return discordId;
  }
  
  public void setDiscordId(long discordId) {
    
    this.discordId = discordId;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) throws IllegalArgumentException {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Firstname is longer than 256 characters.");
    }
      this.firstName = firstName;
    
  }
  
  public String getLastName() {
    
    return lastName;
  }
  
  public void setLastName(String lastName) throws IllegalArgumentException {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Lastname is longer than 256 characters.");
    }
      this.lastName = lastName;
    
  }
  
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  
  public void addCourse(Course course) {
    if(this.courses != null) {
      this.courses.add(course);
    } else {
      throw new IllegalStateException("Courses is null.");
    }
  }
  
  public void removeCourse(Course course) {
    if(courses != null) {
      this.courses.remove(course);
    } else {
      throw new IllegalStateException("Courses is null.");
    }
  }

}