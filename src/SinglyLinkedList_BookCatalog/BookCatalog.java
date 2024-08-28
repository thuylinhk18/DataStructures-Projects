/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_BookCatalog;

/**
 *
 * @author bebet
 */
public class BookCatalog {

    private Node head;

    // Method to check the linked list is empty
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check the linked list has only one node
    public boolean hasOnlyOneNode() {
        return !isEmpty() && head.next == null;
    }

    public boolean isNullOrBlank(String dataToCheckNull) {
        return dataToCheckNull == null || dataToCheckNull.isBlank();
    }

    //Method to check format ISBN
    public boolean checkISBNFormat(String ISBN) {
        char[] toCharArray = ISBN.toCharArray();

        // Check if the length of ISBN is either 10 or 13
        if (toCharArray.length != 13 && toCharArray.length != 10) {
            return false;
        }
        // Check if all characters are digits
        for (char c : toCharArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    //Method to check unique ISBN
    public boolean doesISBNExist(String ISBN) {
        Node current = head;
        while (current != null) {
            if (current.ISBN.equals(ISBN)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Method to check duplicate
    public boolean checkBookExisted(String bookName, String author, String ISBN) {
        Node current = head;
        while (current != null) {
            if ((!isNullOrBlank(current.title) && current.title.equalsIgnoreCase(bookName))
                    && (!isNullOrBlank(current.author) && current.author.equalsIgnoreCase(author))
                    && (!isNullOrBlank(current.ISBN) && current.ISBN.equalsIgnoreCase(ISBN))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Method to display the catalog
    public void displayCatalog() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("The catalog is empty!");
        } else {
            System.out.printf("%-5s %-30s %-20s %-15s%n", "No.", "Title", "Author", "ISBN");
            int i = 1;
            while (current != null) {
                System.out.printf("%-5d %-30s %-20s %-15s%n", i, current.title, current.author, current.ISBN);
                i++;
                current = current.next;
            }
        }
    }

    public void addBook(String bookName, String author, String IBSN) {
        //If the list is empty
        if (isEmpty()) {
            Node bookToAdd = new Node(bookName, author, IBSN);
            head = bookToAdd;
            System.out.println("Add book successfully!");
        } else if (checkBookExisted(bookName, author, IBSN)) {
            System.out.println("The book has already been in the list!");
        } else {
            Node bookToAdd = new Node(bookName, author, IBSN);
            Node current = head;
            //After the loop, current is the last node
            while (current.next != null) {
                current = current.next;
            }
            // Add the bookToAdd node at the end of the list
            current.next = bookToAdd;
            System.out.println("Add book successfully!");
        }
        displayCatalog();
    }

    //Method to remove book in catalog
    public void removeBook(String bookName) {
        // Check if the list is empty
        if (isEmpty()) {
            System.out.println("The catalog is empty, nothing to remove");
        } //Check if the book to remove is the head node
        else if (head.title.equalsIgnoreCase(bookName)) {
            head = head.next;
            System.out.println("Book was removed successfully!");
        } else {
            Node current = head;
            //After the loop, the current is the previous node of bookToRemove node
            while (current.next != null && !current.next.title.equalsIgnoreCase(bookName)) {
                current = current.next;
            }
            // Check if the book was not found
            if (current.next == null) {
                System.out.println("The book was not found!");
            } else {
                current.next = current.next.next;
                System.out.println("Book was removed successfully!");
            }
        }
        displayCatalog();
    }

    public void searchBookByName(String bookName) {
        if (isEmpty()) {
            System.out.println("The catalog is empty");
        } else {
            Node current = head;
            while (current != null && !current.title.equalsIgnoreCase(bookName)) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("No book was found!");
            } else {
                System.out.printf("%-30s %-20s %-15s%n", "Title", "Author", "ISBN");
                System.out.printf("%-30s %-20s %-15s%n", current.title, current.author, current.ISBN);
            }
        }
    }
}
