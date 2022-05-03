/**
 * 
 */
package com.nista2121.coursemanagement;

import java.io.Serializable;

/**
 * @author Stanislas Mbengue
 * version: 1.0
 *
 */
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseLabel;
	private int courseId;
	private String courseName;
	private String courseGrade;
	
	public Course(String courseLabel, int courseId, String courseName, String courseGrade) {
		this.courseLabel = courseLabel;
		this.courseId = courseId;
		this.courseName = courseName;
		
		if(courseGrade == null) {
			this.courseGrade = "n/a";
		}else
			this.courseGrade = courseGrade;
	}
	

	public Course(String courseLabel, int courseId , String courseName) {
		this(courseLabel, courseId, courseName, "");
	}

	
	public String getCourseLabel() {
		return courseLabel;
	}

	public void setCourseLabel(String courseLabel) {
		this.courseLabel = courseLabel;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	
	/**
	 * Check if this course has been taken before
	 */
	public boolean taken() {
		if(this.courseGrade != "n/a" || this.courseGrade != "")
			return true;
		return false;
	}
	
	public boolean equals(Object other) {
		Course otherCourse;
		if(other instanceof Course) {
			 otherCourse = (Course) other;
			 if( courseLabel.equals(otherCourse.courseLabel) && (courseId == otherCourse.getCourseId()) ) {
				 return true;
			 }
		}		
		return false;
		
	}
	public String toString() {
		String course = "[ " + this.courseLabel + " " + this.courseId + " " + this.courseName + this.courseGrade + " ]" ;
		return course;
	}

}
