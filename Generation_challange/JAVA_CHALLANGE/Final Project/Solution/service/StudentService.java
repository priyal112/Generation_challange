package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        for (Student student : students.values()) {
            System.out.println(student);
            List<Course> enrolledCourses = student.getCourses();
            if (!enrolledCourses.isEmpty()) {
                System.out.println("Enrolled Courses:");
                for (Course course : enrolledCourses) {
                    System.out.println(course);
                }
            }
            List<Course> approvedCourses = student.getApprovedCourses();
            if (!approvedCourses.isEmpty()) {
                System.out.println("Approved Courses:");
                for (Course course : approvedCourses) {
                    System.out.println(course);
                }
            }
            System.out.println("----------------------------------");
    }
}

    public void enrollToCourse( String studentId, Course course )
    {
        Student student = students.get(studentId);
        if (student != null) {
            student.enrollToCourse(course);
        } else {
            System.out.println("Student with ID: " + studentId + " not found.");
        }
    }


}
