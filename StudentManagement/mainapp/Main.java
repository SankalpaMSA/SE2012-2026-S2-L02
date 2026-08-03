package mainapp;

import models.Course;
import models.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Student[] students = new Student[100];
        int studentCount = 0;
        boolean exit = false;
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (!exit) {
            System.out.println("\n Student Management System");
            System.out.println("1. Enroll a Student");
            System.out.println("2. List all Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Sort Students by name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    if (studentCount < students.length) {
                        students[studentCount] = new Student(id, name);
                        studentCount++;
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.out.println("Limit Exceeded.");
                    }  
                    break;
                
                case 2:
                    System.out.println("Student List");
                    if (studentCount == 0) {
                        System.err.println("No students enrolled.");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println(students[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    String searchid = sc.nextLine();

                    Student result = null;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getId().equalsIgnoreCase(searchid)) {
                            result = students[i];
                            break;
                        }
                    }
                    if (result != null) {
                        System.out.println("Found: " + result);
                    } else {
                        System.out.println("No student record on " + searchid);
                    }
                    break;
                
                case 4:
                    for (int i = 0; i < studentCount - 1; i++) {
                        for (int j = 0; j < studentCount - i - 1; j++) {
                            if (students[j].getName().compareToIgnoreCase(students[j + 1].getName()) > 0) {
                                Student temp = students[j];
                                students[j] = students[j + 1];
                                students[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Students are sorted by name.");
                    break;
                
                case 5:
                    exit = true;
                    System.out.println("Exiting Program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }

        }
    }
}