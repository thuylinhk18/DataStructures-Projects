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
