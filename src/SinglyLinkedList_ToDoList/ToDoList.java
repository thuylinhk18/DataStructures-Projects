/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_ToDoList;

/**
 *
 * @author bebet
 */
//26/08/2024
public class ToDoList {

    private Node head; //head of the linked list

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOnlyOneNode() {
        // The first way
        //        if (!isEmpty() && (head.next == null)) {
        //            return true;
        //        } else {
        //            return false;
        //        }
        // The second way
        return !isEmpty() && head.next == null;
    }

    //Method to check duplicate
    public boolean checkTaskExisted(String taskName) {
        Node current = head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(taskName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Method to display the to-do list
    public void displayTheList() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("To do list: ");
            int i = 1;
            while (current != null) {
                System.out.println(i + ". " + current.data + "   " + current.state);
                i++;
                current = current.next;
            }
        }
    }

    //Method to add task at the beginning
    public void addTaskAtTheBeginning(String taskName) {
        Node nodeToAdd = new Node(taskName);
        //Check if the task is existed
        if (checkTaskExisted(taskName)) {
            System.out.println("The task has already been in the list!");
        } else {
            nodeToAdd.next = head;
            head = nodeToAdd;
            System.out.println("Add the task at the beginning successfully!");
        }
        displayTheList();
    }

    //Method to add task at the end 
    public void addTaskAtTheEnd(String taskName) {
        //If the list is empty
        if (isEmpty()) {
            addTaskAtTheBeginning(taskName);
            System.out.println("Add the task at the end successfully!");
        } else if (checkTaskExisted(taskName)) {
            System.out.println("The task has already been in the list!");
        } else {
            Node nodeToAdd = new Node(taskName);
            Node current = head;
            //After the loop, current is the last node
            while (current.next != null) {
                current = current.next;
            }
            // Add the nodeToAdd node at the end of the list
            current.next = nodeToAdd;
            System.out.println("Add the task at the end successfully!");
        }
        displayTheList();
    }
    //Method to remove task in the list
    public void removeTask(String taskName) {
        // Check if the list is empty
        if (isEmpty()) {
            System.out.println("The to-do list is empty, nothing to remove");
        } //Check if the task to remove is the head node
        else if (head.data.equalsIgnoreCase(taskName)) {
            head = head.next;
            System.out.println("Task was removed successfully!");
        } else {
            Node current = head;
            //After the loop, the current is the previous node of nodeToRemove node
            while (current.next != null && !current.next.data.equalsIgnoreCase(taskName)) {
                current = current.next;
            }
            // Check if the task was not found
            if (current.next == null) {
                System.out.println("The task was not found!");
            } else {
                current.next = current.next.next;
                System.out.println("Task was removed successfully!");
            }
        }
        displayTheList();
    }
    // Method to change state of the task to completed
    public void changeState(Node nodeToChangeState) {
        nodeToChangeState.setState("Completed");
    }

    public void markAsCompleted(String taskName) {
        if (isEmpty()) {
            System.out.println("The to-do list is empty!");
        } else {
            Node current = head;
            while (current != null && !current.data.equalsIgnoreCase(taskName)) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("The task was not found!");
            } else {
                changeState(current);
                System.out.println(taskName + " has been marked as completed!");
                displayTheList();
            }
        }

    }
    //Method to count the number of tasks in the to-do list
    public int countNumOfTasks() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
