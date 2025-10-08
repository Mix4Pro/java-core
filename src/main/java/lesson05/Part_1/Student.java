package lesson05.Part_1;

import java.util.ArrayList;

public class Student extends Person {
    private static int studentIdCounter = 0;
    private final int studentId;
    private final ArrayList<Course> enrolledCourses = new ArrayList<>();

    Student(String name, int age, String email) {
        super(name, age, email);
        studentId = ++studentIdCounter;
    }

    @Override
    public String role() {return "Student";}

    public int getStudentId() {
        return this.studentId;
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println("Course has been successfully added");
    }

    public void showStudentInfo() {
        System.out.println();
        System.out.println("Information about the student : ");
        System.out.println("Student id : " + this.studentId);
        System.out.println("Name : " + super.getName());
        System.out.println("Age : " + super.getAge());
        System.out.println("Email : " + super.getEmail());
        System.out.println("Enrolled courses : ");
        if (enrolledCourses.isEmpty()) {
            System.out.println("There are no courses yet");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println("\t" + course.getName());
            }
        }
    }

    public void deleteCourse(Course course) {
        int course_index = -1;
        if (!enrolledCourses.isEmpty()) {
            boolean found = false;
            for (Course collection_course : enrolledCourses) {
                if (collection_course.getName().equals(course.getName())) {
                    found = true;
                    course_index = enrolledCourses.indexOf(collection_course);
                    break;
                }
            }

            if (found) {
                enrolledCourses.remove(course_index);
            } else {
                System.out.println("The student does not attend this course");
            }
        } else {
            System.out.println("There are no courses yes");
        }
    }
}