/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package phonee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Phonee {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MobileContactsGUI());
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//        mycontacts phoneBook = new mycontacts();
//
//        while (true) {
//            System.out.println("Phone Book Directory");
//            System.out.println("1. Add contact");
//            System.out.println("2. Search contact");
//            System.out.println("3. Display all contacts");
//            System.out.println("4. Delete contact");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();  
//
//            switch (choice) {
//                case( 1):{
//                    System.out.print("Enter name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter phone number: ");
//                    String phoneNumber = scanner.nextLine();
//                    phoneBook.insert(new contact(name, phoneNumber));
//                    System.out.println("Contact added.");
//                    break;
//                }
//                case (2):{
//                    System.out.print("Enter name to search: ");
//                    String searchName = scanner.nextLine();
//                    contact contact = phoneBook.search(searchName);
//                    if (contact != null) {
//                        System.out.println("Contact found - Name: " + contact.name + ", Phone: " + contact.number);
//                    } else {
//                        System.out.println("Contact not found.");
//                    }
//                    break;
//                }
//                case (3):{
//                    System.out.println("All Contacts:");
//                    phoneBook.traverse(phoneBook.root);
//                    break;
//                }
//                case (4):{
//                    System.out.print("Enter name to delete: ");
//                    String deleteName = scanner.nextLine();
//                    phoneBook.delete(deleteName);
//                    System.out.println("Contact deleted.");
//                    break;
//                }
//                case (5):{
//                    System.out.println("Exiting...");
//                    System.exit(0);
//                    break;
//                }
//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.");
//            }
//
//            System.out.println();
//        }
//    }
    }
    

