import java.util.*;

class Classroom {
    String name;
    List<Student> students;
    List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }
}

class Student {
    String studentId;

    public Student(String studentId) {
        this.studentId = studentId;
    }
}

class Assignment {
    String details;
    List<Student> submittedBy;

    public Assignment(String details) {
        this.details = details;
        this.submittedBy = new ArrayList<>();
    }
}

public class VCM {
    private Map<String, Classroom> classrooms;
    private Map<String, Student> students;

    public VCM() {
        this.classrooms = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            classrooms.put(name, new Classroom(name));
            System.out.println("Classroom " + name + " has been created.");
        } else {
            System.out.println("Classroom " + name + " already exists.");
        }
    }

    public void removeClassroom(String name) {
        if (classrooms.containsKey(name)) {
            classrooms.remove(name);
            System.out.println("Classroom " + name + " has been removed.");
        } else {
            System.out.println("Classroom " + name + " does not exist.");
        }
    }

    public void listClassrooms() {
        System.out.println("Classrooms:");
        for (Classroom classroom : classrooms.values()) {
            System.out.println(classroom.name);
        }
    }

    public void addStudent(String studentId, String className) {
        if (classrooms.containsKey(className)) {
            if (!students.containsKey(studentId)) {
                students.put(studentId, new Student(studentId));
            }
            classrooms.get(className).students.add(students.get(studentId));
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listStudents(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Students in " + className + ":");
            for (Student student : classrooms.get(className).students) {
                System.out.println(student.studentId);
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String details) {
        if (classrooms.containsKey(className)) {
            Assignment assignment = new Assignment(details);
            classrooms.get(className).assignments.add(assignment);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String details) {
        if (classrooms.containsKey(className)) {
            for (Assignment assignment : classrooms.get(className).assignments) {
                if (assignment.details.equals(details)) {
                    assignment.submittedBy.add(students.get(studentId));
                    System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                    return;
                }
            }
            System.out.println("Assignment " + details + " does not exist in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public static void main(String[] args) {
        VCM manager = new VCM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("add_classroom")) {
                manager.addClassroom(input[1]);
            } else if (input[0].equals("remove_classroom")) {
                manager.removeClassroom(input[1]);
            } else if (input[0].equals("list_classrooms")) {
                manager.listClassrooms();
            } else if (input[0].equals("add_student")) {
                manager.addStudent(input[1], input[2]);
            } else if (input[0].equals("list_students")) {
                manager.listStudents(input[1]);
            } else if (input[0].equals("schedule_assignment")) {
                manager.scheduleAssignment(input[1], String.join(" ", Arrays.copyOfRange(input, 2, input.length)));
            } else if (input[0].equals("submit_assignment")) {
                manager.submitAssignment(input[1], input[2], String.join(" ", Arrays.copyOfRange(input, 3, input.length)));
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}