package me.jcsawyer.classroombot.entities;

import javax.annotation.Nullable;
import java.util.List;

public class Student {
  private int studentID;
  private long discordID;
  private String firstName;
  private String lastName;
  
  @Nullable
  private List<Course> courses = null;
  
  public Student(int studentID, long discordID, String firstName, String lastName) {
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
  
  public void setFirstName(String firstName) {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Firstname is longer than 256 characters.");
    } else {
      this.firstName = firstName;
    }
  }
  
  public String getLastName() {
    
    return lastName;
  }
  
  public void setLastName(String lastName) {
    if(firstName.length() > 256) {
      throw new IllegalArgumentException("Lastname is longer than 256 characters.");
    } else {
      this.lastName = lastName;
    }
  }
  
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

}