package Test;

import domain.*;

import java.util.Scanner;



public class Main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fill Student" +
                "Enter Id, Name, LastName, Group, Department:");
        Student student = new Student(Integer.parseInt(scanner.nextLine()), scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
        student.printInFile();

        System.out.println("Fill Order\n" +
                "Enter Id, Name, Courier:");
        Order order = new Order(Integer.parseInt(scanner.nextLine()), scanner.nextLine(), scanner.nextLine());
        order.printInFile();

        System.out.println("Fill Contact\n" +
                "Enter Name, LastName, Address:");
        Contact contact = new Contact( scanner.nextLine(), scanner.nextLine(),  scanner.nextLine());
        contact.printInFile();

        System.out.println("Fill CloseContact\n" +
                "Enter Name, LastName, Address, Birthday, FamilyConnection:");
        CloseContact closeContact = new CloseContact(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        closeContact.printInFile();
    }
    
}
