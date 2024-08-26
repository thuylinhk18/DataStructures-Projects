/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_ToDoList;

import java.util.Scanner;

/**
 *
 * @author bebet
 */
public class Test {

    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task At The Beginning Of The List");
            System.out.println("2. Add Task At The End Of The List");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Display Tasks");
            System.out.println("6. Count The Number Of Tasks");
            System.out.println("7. List The Completed Tasks");
            System.out.println("8. List The Uncompleted Tasks");
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
                    System.out.print("Enter task to add at the beginning: ");
                    String taskToAddAtBeginning = scanner.nextLine();
                    toDoList.addTaskAtTheBeginning(taskToAddAtBeginning);
                    break;
                case 2:
                    System.out.print("Enter task to add at the end: ");
                    String taskToAddAtTheEnd = scanner.nextLine();
                    toDoList.addTaskAtTheEnd(taskToAddAtTheEnd);
                    break;
                case 3:
                    System.out.print("Enter task to mark as completed: ");
                    String taskToMark = scanner.nextLine();
                    toDoList.markAsCompleted(taskToMark);
                    break;
                case 4:
                    System.out.print("Enter task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    toDoList.removeTask(taskToRemove);
                    break;
                case 5:
                    toDoList.displayTheList();
                    break;
                case 6:
                    System.out.println("The number of tasks that you have is: " + toDoList.countNumOfTasks());
                    break;
                case 7:
                    System.out.println("The number of completed tasks is: " + toDoList.countNumOfCompletedTasks()+"/"+toDoList.countNumOfTasks());
                    toDoList.displayCompletedTasks();
                    break;
                case 8:
                    System.out.println("The number of uncompleted tasks is: " + toDoList.countNumOfUncompletedTasks());
                    toDoList.displayUncompletedTasks();
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
