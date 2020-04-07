package view;
import controller.School;
import model.Student;

import java.util.Scanner;

public class Students {
    private static Scanner scanner = new Scanner(System.in);
    private static School studentList = new School("B01010","Nguyen Tuan Anh","Ha Noi","0904818238");
    public static void main(String[] args) {
        boolean exit = false;
        startFunction();
        printActions();
        while (!exit){
            System.out.println("\nEnter action: (3 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("\nExitting......");
                    exit = true;
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentList.printStudent();
                    break;
                case 3:
                    studentList.saveStudent();
                    break;
            }
        }
    }
    public static void addStudent(){
        System.out.println("Enter new StudentId: ");
        String id = scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter phone: ");
        String phone = scanner.nextLine();
        Student newStudent = Student.addSudent(id,name,address,phone);
        if (studentList.addNewStudent(newStudent)){
            System.out.println("New student added: id ="+id+" name = "+name+" address = "+address+" phone = "+phone);
        }else {
            System.out.println("Cannot add, "+id+" already on file");
        }
    }
    private static void startFunction() {
        System.out.println("Starting function...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - Exit\n"
                + "1  - To add a new student\n"
                + "2  - To print student\n"
                + "3  - Save\n");
        System.out.println("Choose your action: ");
    }
}
