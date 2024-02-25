import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
    public String courseCode;
    public String courseName;
    public String department;
    public List<Student> students;

    public Course(String courseCode, String courseName, String department) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }

        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        this.students.add(student);
    }

   

   

    public List<Student> viewStudents() {
        for (Student student : students) {

            System.out.println(students);
   
           }
        return students;

        
    }

    public static void main(String[] args) {
        // Create a new Course object
        Course course = new Course("CS101", "Introduction to Programming", "Computer Science");

        // Take input of students' data
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students to enroll: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student " + (i + 1) + " data:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Roll number: ");
            String rollNumber = scanner.nextLine();
            System.out.print("Batch: ");
            String batch = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            // Create a new Student object and enroll it in the course
            Student student = new Student(name, rollNumber, batch, department);
            course.enrollStudent(student);
        }



        // View students
        System.out.println("\nEnrolled Students:");

        List<Student> students = course.viewStudents();

        for (Student student : students) {

            System.out.println(student.toString());

        }

        
    }
}

// class Student {
//     private String name;
//     private String rollNumber;
//     private String batch;
//     private String department;

//     public Student(String name, String rollNumber, String batch, String department) {
//         this.name = name;
//         this.rollNumber = rollNumber;
//         this.batch = batch;
//         this.department = department;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getRollNumber() {
//         return rollNumber;
//     }

//     public String getBatch() {
//         return batch;
//     }

//     public String getDepartment() {
//         return department;
//     }

//     @Override
//     public String toString() {
//         return "Name: " + name + ", Roll Number: " + rollNumber + ", Batch: " + batch + ", Department: " + department;
//     }
// }