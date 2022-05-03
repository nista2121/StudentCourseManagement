package com.nista2121.coursemanagement;

public class Main {

	public static void main(String[] args) {
		//create a new object for testing
		ManageCourse manageCourse = new ManageCourse();
		//add some random course
		manageCourse.addCourse(new Course("PH", 105, "Into to Physic", "A"));
		manageCourse.addCourse(new Course("CS", 230, "Into to Computer Sciece"));
		manageCourse.addCourse(new Course("EN", 100, "English 100", "A"));
		

		System.out.println(manageCourse);
		
		//find a course and add a new course after , 
		// addCourseAtLocation
		Course cs = manageCourse.findCourse("CS", 230); 
		
		manageCourse.AddCourseAtLocation(cs, new Course("MAT" ,133 , "Single Variable"));
		
		//print
		System.out.println(manageCourse);
	}

}
