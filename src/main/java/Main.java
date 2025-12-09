import controller.StudentController;
import model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Get All Students");
            System.out.println("4. Exit Program");

            System.out.print("Enter your choice: ");
            int choice = -1;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline left by nextInt()
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine().trim();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Age: ");
                    int age;
                    try {
                        age = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Returning to menu.");
                        break;
                    }

                    Student s = new Student(email, name, age);

                    try {
                        if (StudentController.getStudent(email)) {
                            System.out.println("Student already exists!");
                        } else {
                            StudentController.addStudent(s);
                            System.out.println("Student added successfully!");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Email: ");
                    String email2 = sc.nextLine().trim();

                    try {
                        if (StudentController.getStudent(email2)) {
                            // Student exists -> delete
                            StudentController.deleteStudent(email2);
                            System.out.println("Student deleted successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3:
                    try{
                        System.out.println(StudentController.getAllStudents());
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}