package lesson05.Part_1;

import java.util.HashMap;

public class Course {
    private final String name;
    private final Teacher teacher;
    private final HashMap<Integer, Student> studentCollection = new HashMap<>();
    private final HashMap<Student, Integer> assessedStudentsCollection = new HashMap<>();
    private final HashMap<Student, Boolean> attendanceStudentCollection = new HashMap<>();

    Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.teacher.addCourse(this);
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getTeacherName() {
        return this.teacher.getName();
    }

    public void addStudent(Student student) {
        boolean found = false;
        if (studentCollection != null) {
            for (Student collection_student : studentCollection.values()) {
                if (student.getEmail().equals(collection_student.getEmail()) || student.getStudentId() == collection_student.getStudentId()) {
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            studentCollection.put(student.getStudentId(), student);
            attendanceStudentCollection.put(student, false);
            student.addCourse(this);
        } else {
            System.out.println("There is already a student like this on this course");
        }
    }

    public void deleteStudent(Student student) {
        boolean found = false;
        int student_to_remove_key_from_student_collection = 0;
        int student_to_remove_key_from_attendance_collection = 0;
        for (Student collection_student : studentCollection.values()) {
            if (student.getStudentId() == collection_student.getStudentId()) {
                student_to_remove_key_from_student_collection = collection_student.getStudentId();

                found = true;
            }
        }

        if (found) {
            studentCollection.remove(student_to_remove_key_from_student_collection);

        } else {
            System.out.println("There is no student like this on this course");
        }
    }

    public void assessStudent(Student student, int mark) {
        if (mark > 0 && mark <= 5) {
            boolean found = false;
            for (Student collection_student : studentCollection.values()) {
                if (collection_student.getStudentId() == student.getStudentId()) {
                    found = true;
                    assessedStudentsCollection.put(student, mark);
                }
            }

            if (!found) {
                System.out.println("There is no student like this on this course");
            }
        } else {
            System.out.println("Incorrect mark");
        }
    }

    public void markStudentAttendance(Student student) {
        boolean found = false;
        for (Student collection_student : studentCollection.values()) {
            if (collection_student.getStudentId() == student.getStudentId()) {
                found = true;
                attendanceStudentCollection.put(student, found);
            }
        }

        if (!found) {
            System.out.println("There is no student like this one this course");
        }
    }

    public void showCourseInfo() {
        System.out.println();
        System.out.println("Course name " + this.name);
        System.out.println("Teacher : " + this.teacher.getName());
        for (Student student : studentCollection.values()) {
            System.out.println("Student : " + student.getName());
            boolean attends = attendanceStudentCollection.get(student);
            if (attends) {
                System.out.println("Attendance : attends");
            } else {
                System.out.println("Attendance : does not attend");
            }
            if (assessedStudentsCollection.get(student) == null) {
                System.out.println("Grade : 0");
            } else {
                System.out.println("Grade : " + assessedStudentsCollection.get(student));
            }
        }
    }
}