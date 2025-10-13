package lesson05.Part_1;

class Main {
    public static void main(String[] args) {
        Student student = new Student("Alex", 12, "someemail@gmail.com");
        student.showStudentInfo();

        Student student_2 = new Student("Someone else", 20, "someoneelse@gmail.com");
        Student student_3 = new Student("Some boi", 10, "someboi@gmail.com");


        Teacher teacher = new Teacher("Mr Doggy", 30, "mrdoggy@gmail.com");
        teacher.showTeachInfo();

        Course course = new Course("Math", teacher);
        teacher.showTeachInfo();
        System.out.println("---------------------------------------");

        course.addStudent(student);
        course.addStudent(student_2);
        course.addStudent(student_2);


        System.out.println("---------------------------------------");
        student.showStudentInfo();

        System.out.println("---------------------------------------");
        course.markStudentAttendance(student);
        course.assessStudent(student, 5);
        course.showCourseInfo();
        student_3.deleteCourse(course);
    }
}