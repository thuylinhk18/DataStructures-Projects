/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_ToDoList;

public class Node {
    //Data stored in the node
   String data;
   //Reference to the next node in the sequence
   Node next;

   //Constructor to initialize node with data
    public Node() {
    }
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
//Getters and setters for data and next reference
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

   
}
