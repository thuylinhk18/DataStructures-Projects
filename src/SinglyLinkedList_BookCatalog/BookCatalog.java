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

    //Method to check duplicate
    public boolean checkBookExisted(String bookName) {
        Node current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(bookName)) {
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
            Node bookToAdd = new Node(IBSN, author, IBSN);
            head = bookToAdd;
            System.out.println("Add book successfully!");
        } else if (checkBookExisted(bookName)) {
            System.out.println("The book has already been in the list!");
        } else {
            Node bookToAdd = new Node(IBSN, author, IBSN);
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
        } //Check if the task to remove is the head node
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
}
