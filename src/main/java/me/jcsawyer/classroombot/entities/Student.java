package me.jcsawyer.classroombot.entities;

import javax.annotation.Nullable;
import java.util.List;

public class Student {
  private int studentID;
  private long discordID;
  private String firstName;
  private String lastName;
  
  private List<Course> courses = null;
  
  public Student(int studentID, long discordID, String firstName, String lastName, List<Course> courses)
    throws IllegalArgumentException {
    new Student(studentID, discordID, firstName, lastName);
    this.courses = courses;
  }
  
  public Student(int studentID, long discordID, String firstName, String lastName)
    throws IllegalArgumentException {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Firstname is longer than 256 characters.");
    } else if(lastName.length() > 256) {
      throw new IllegalArgumentException("Lastname is longer than 256 characters.");
    }
    this.studentID = studentID;
    this.discordID = discordID;
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
  
  public int getStudentID() {
    return studentID;
  }
  
  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }
  
  public long getDiscordID() {
    return discordID;
  }
  
  public void setDiscordID(long discordID) {
    
    this.discordID = discordID;
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