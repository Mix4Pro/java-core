package lesson05.Part_1;

import java.util.ArrayList;

public class Teacher extends Person {
    private final ArrayList<Course> teachingCoursesCollection = new ArrayList<>();

    Teacher(String name, int age, String email) {
        super(name, age, email);
    }

    @Override
    public String role() {return "Teacher";}

    public void addCourse(Course course) {
        boolean found = false;
        for (Course collection_courses : teachingCoursesCollection) {
            if (collection_courses.getName() == course.getName()) {
                found = true;
                System.out.println("Course already exists");
            }
        }

        if (!found) {
            teachingCoursesCollection.add(course);
        }
    }

    public void showTeachInfo() {
        System.out.println();
        System.out.println("Information about the teacher : ");
        System.out.println("Name : " + super.getName());
        System.out.println("Age : " + super.getAge());
        System.out.println("Email : " + super.getEmail());
        System.out.println("Courses that teacher teaches : ");
        if (teachingCoursesCollection.isEmpty()) {
            System.out.println("There are no courses yet");
        } else {
            for (Course course : teachingCoursesCollection) {
                System.out.println("\t" + course.getName());
            }
        }
    }
}