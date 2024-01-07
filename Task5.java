import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourseListing() {
        System.out.println("Course Listing:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + (course.getCapacity() - getRegisteredStudentsCount(course.getCourseCode())));
            System.out.println();
        }
    }

    private int getRegisteredStudentsCount(String courseCode) {
        int count = 0;
        for (Student student : students) {
            if (student.getRegisteredCourses().contains(courseCode)) {
                count++;
            }
        }
        return count;
    }

    public void displayStudentCourses(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                System.out.println("Registered Courses for Student " + studentID + " - " + student.getName() + ":");
                for (String courseCode : student.getRegisteredCourses()) {
                    displayCourseDetails(courseCode);
                }
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }

    private void displayCourseDetails(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                System.out.println("Course Code: " + course.getCourseCode());
                System.out.println("Title: " + course.getTitle());
                System.out.println("Description: " + course.getDescription());
                System.out.println("Schedule: " + course.getSchedule());
                System.out.println();
                return;
            }
        }
    }

    public void registerStudent(int studentID, String name) {
        students.add(new Student(studentID, name));
    }

    public void registerCourse(int studentID, String courseCode) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                if (isCourseAvailable(courseCode) && !student.getRegisteredCourses().contains(courseCode)) {
                    student.registerCourse(courseCode);
                    System.out.println("Course registration successful for Student " + studentID + " - " + student.getName());
                    return;
                } else if (!isCourseAvailable(courseCode)) {
                    System.out.println("Course with code " + courseCode + " is not available.");
                    return;
                } else {
                    System.out.println("Student " + studentID + " - " + student.getName() + " is already registered for course " + courseCode);
                    return;
                }
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }

    public void dropCourse(int studentID, String courseCode) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                if (student.getRegisteredCourses().contains(courseCode)) {
                    student.dropCourse(courseCode);
                    System.out.println("Course dropped successfully for Student " + studentID + " - " + student.getName());
                    return;
                } else {
                    System.out.println("Student " + studentID + " - " + student.getName() + " is not registered for course " + courseCode);
                    return;
                }
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }

    private boolean isCourseAvailable(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return getRegisteredStudentsCount(courseCode) < course.getCapacity();
            }
        }
        return false;
    }
}

public class Task5 {
    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        // Adding sample courses
        registrationSystem.addCourse(new Course("CS101", "Introduction to Computer Science", "Fundamental concepts of computer science", 30, "MWF 10:00 AM - 11:30 AM"));
        registrationSystem.addCourse(new Course("ENG201", "English Literature", "Classic and modern literature analysis", 25, "TTH 1:00 PM - 2:30 PM"));
        registrationSystem.addCourse(new Course("MATH301", "Advanced Calculus", "Topics in advanced calculus", 20, "MWF 2:00 PM - 3:30 PM"));

        // Adding sample students
        registrationSystem.registerStudent(1001, "Alice");
        registrationSystem.registerStudent(1002, "Bob");

        // Displaying course listing
        registrationSystem.displayCourseListing();

        // Registering students for courses
        registrationSystem.registerCourse(1001, "CS101");
        registrationSystem.registerCourse(1001, "ENG201");
        registrationSystem.registerCourse(1002, "MATH301");

        // Displaying student courses
        registrationSystem.displayStudentCourses(1001);
        registrationSystem.displayStudentCourses(1002);

        // Dropping a course
        registrationSystem.dropCourse(1001, "ENG201");

        // Displaying updated student courses
        registrationSystem.displayStudentCourses(1001);
    }
}