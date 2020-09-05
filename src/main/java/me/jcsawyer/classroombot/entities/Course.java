package me.jcsawyer.classroombot.entities;

public class Course {
  private int courseID;
  private String shortName;
  private String fullName;
  private boolean optSelfEnrol;
  
  public Course(int courseID, String shortName, String fullName, boolean optSelfEnrol)
    throws IllegalArgumentException {
    
    if(shortName.length() > 128) {
      throw new IllegalArgumentException("Shortname is longer than 128 characters.");
    } else if(fullName.length() > 256) {
      throw new IllegalArgumentException("Fullname is longer than 256 characters.");
    }
    this.courseID = courseID;
    this.shortName = shortName;
    this.fullName = fullName;
    this.optSelfEnrol = optSelfEnrol;
  }
  
  public int getCourseID() {
    return courseID;
  }
  
  public void setCourseID(int courseID) {
    this.courseID = courseID;
  }
  
  public String getShortName() {
    return shortName;
  }
  
  public void setShortName(String shortName) throws IllegalArgumentException{
    if(shortName.length() > 128) {
      throw new IllegalArgumentException("Shortname is longer than 128 characters.");
    }
    this.shortName = shortName;
  }
  
  public String getFullName() {
    return fullName;
  }
  
  public void setFullName(String fullName) throws IllegalArgumentException{
    if(fullName.length() > 256) {
      throw new IllegalArgumentException("Fullname is longer than 256 characters.");
    }
    this.fullName = fullName;
  }
  
  public boolean isOptSelfEnrol() {
    return optSelfEnrol;
  }
  
  public void setOptSelfEnrol(boolean optSelfEnrol) {
    this.optSelfEnrol = optSelfEnrol;
  }
  
  
}
