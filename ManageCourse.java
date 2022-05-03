package com.nista2121.coursemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Manage list of course student, this program will add course, replace course,
 *  remove, and find an existing course
 * @author Stanislas Mbengue
 * version: 1.0
 *
 */
public class ManageCourse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Course> listCourse;

	public ManageCourse() {
		
		listCourse = new ArrayList<>();
	}
	/**
	 * Add a new course to the list
	 * @param course
	 */
	public void addCourse(Course course) {
		if(course != null) {
			listCourse.add(course);
		}
	}
	/**
	 * Add a course at a designated index or after another course
	 * @param targetCourse
	 * @param course
	 */
	public void AddCourseAtLocation(Course targetCourse, Course course) {
		if(targetCourse != null || course != null) {
			//get the location index
			int index = listCourse.indexOf(targetCourse);
			if(index  != -1) {
				listCourse.add(index + 1, course);
			}
		}
	}
	/**
	 * Replace an existing course with a new course
	 * @param oldCourse course to be replace or remove
	 * @param newCourse course to be added 
	 */
	public void replaceCourse(Course oldCourse, Course newCourse) {
		//do nothing if oldCourse or new course is null
		if(oldCourse == null || newCourse == null) {
			return; 
		}
		int index = listCourse.indexOf(oldCourse);
		if(index != -1) {
			listCourse.set(index, newCourse);
		}
	}
	/**
	 * Find a course in the list, and return it
	 * @param label
	 * @param id
	 * @return course or null if course does not exist
	 */
	public Course findCourse(String label, int id) {
		//find a specific course
		for(Course course : listCourse) {
			if(course.getCourseLabel() == label && course.getCourseId() == id)
				return course;
		}
		return null;
	}
	//return an iterator for this object 
	public Iterator<Course> iterator(){
		return listCourse.iterator();
		
	}
	/**
	 * return a String representation of the courses
	 */
	public String toString() {
		
		//loop through the list of course
		StringBuilder builder = new StringBuilder();
		
		for(Course course : listCourse) {
			builder.append(course + " \n") ;
		}
		return builder.toString();
	}
	/**
	 * save this object in a file
	 * @param filename
	 * @throws IOException 
	 */
	public void save(String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(this);
		os.flush();
		os.close();
	}
	/**
	 * Load manage course data to a file
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static  ManageCourse load (String filename) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ManageCourse mc = (ManageCourse) ois.readObject();
		ois.close();
		return mc;
		
	}

}
