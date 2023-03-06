package org.pw;

import org.pw.Controller.UserController;
import org.pw.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        System.out.println("1. Save User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. Get User by ID");
        System.out.println("5. Get All User Details");
        System.out.println("Enter the choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                User us = new User();
                System.out.println("Enter the id");
                us.setId(scanner.nextInt());
                System.out.println("Enter the name");
                us.setName(scanner.nextLine());
                scanner.nextLine();
                System.out.println("Enter Gender");
                us.setGender(scanner.nextLine());
                System.out.println("Enter Email");
                us.setEmail(scanner.nextLine());
                System.out.println("Enter Phone number");
                us.setPhone(scanner.nextLong());
                us = controller.insertUser(us);
                System.out.println(us);
                break;
            }
            case 2: {
                System.out.println("Enter the user ID: ");
                int id = scanner.nextInt();
                User us = new User();
                System.out.println("Enter the name");
                us.setName(scanner.nextLine());
                System.out.println("Enter Gender");
                us.setGender(scanner.nextLine());
                System.out.println("Enter Email");
                us.setEmail(scanner.nextLine());
                System.out.println("Enter Phone number");
                us.setPhone(scanner.nextLong());
                us = controller.updateUser(us);
                System.out.println(us);
                break;
            }
            case 3: {
                System.out.println("Enter the user ID: ");
                int id = scanner.nextInt();
                int result = controller.deleteUser(id);
                if (result == 1) {
                    System.out.println("Data Deleted");
                } else {
                    System.out.println("Data not deleted");
                }
                break;
            }
            case 4: {
                System.out.println("Enter the user ID: ");
                int id = scanner.nextInt();
                User u = controller.getUserById(id);
                System.out.println(u);
                break;
            }
            case 5: {
                List<User> list = new ArrayList<>();
                list = controller.getAllUser();
                System.out.println(list);
                break;
            }
            default:
                System.out.println("Invalid Choice");
        }
    }
}