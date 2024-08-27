/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_BookCatalog;

import java.util.Scanner;

/**
 *
 * @author bebet
 */
public class Test {

    public static void main(String[] args) {

        BookCatalog bookCatalog = new BookCatalog();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search For Book By Title");
            System.out.println("4. Display Catatog");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter the title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String bookISBN = scanner.nextLine();
                    bookCatalog.addBook(bookTitle, bookAuthor, bookISBN);
                    break;
                case 2:
                    System.out.print("Enter book name: ");
                    String bookToRemove = scanner.nextLine();
                    bookCatalog.removeBook(bookToRemove);
                    break;
                case 3:
                    System.out.print("Enter book name: ");
                    String bookToSearch = scanner.nextLine();
                    bookCatalog.searchBookByName(bookToSearch);
                    break;
                case 4:
                    bookCatalog.displayCatalog();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println("=========================================");
        } while (choice != 0);

        scanner.close();
    }
}
