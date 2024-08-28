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
                    boolean isNullOrBlank;
                    String bookTitle,
                     bookAuthor,
                     bookISBN;
                    
                    //Enter the title
                    do {
                        System.out.print("Enter the title: ");
                        bookTitle = scanner.nextLine().trim();  // Trim to remove any leading or trailing spaces
                        isNullOrBlank = bookCatalog.isNullOrBlank(bookTitle);
                        if (isNullOrBlank) {
                            System.out.println("Book Title can not be null or blank. Please enter a valid title!");
                        }
                    } while (isNullOrBlank);
                    
                    //Enter the author
                    do {
                        System.out.print("Enter the author: ");
                        bookAuthor = scanner.nextLine().trim(); // Trim to remove any leading or trailing spaces
                        isNullOrBlank = bookCatalog.isNullOrBlank(bookAuthor);
                        if (isNullOrBlank) {
                            System.out.println("Book Author can not be null or blank. Please enter a valid book author!");
                        }
                    } while (isNullOrBlank);
                    
                    //Enter the the ISBN
                    boolean isISBNValid = false;
                    // Loop to validate ISBN format
                    do {
                        System.out.print("Enter ISBN: ");
                        bookISBN = scanner.nextLine().trim(); // Trim to remove any leading or trailing spaces
                        if (bookCatalog.isNullOrBlank(bookISBN)) {
                            System.out.println("ISBN can not be null!");
                            continue;
                        }
                        isISBNValid = bookCatalog.checkISBNFormat(bookISBN);
                        if (!isISBNValid) {
                            System.out.println("ISBN must have 10 or 13 digits and all characters must be digits!");
                            System.out.println("Please enter a valid ISBN!");
                        }
                    } while (!isISBNValid);
                    // Add book to catalog after valid inputs
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
