/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_PlaylistManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bebet
 */
public class Playlist {

    private Node head; //Head of the linked list

    //Method to check the list is empty
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }

    }

    //Method to check the list has only one node
    public boolean hasOnlyOneNode() {
        return !isEmpty() && head.next == null;
        // return true if the list is not empty and just has only one node
    }

    //Method to check songDuplicated
    public boolean checkSongExisted(String songName) {
        Node current = head;
        //If we do not check the current is null, that can causing NullPointerException
        while (current != null) {
            if (current.data.equalsIgnoreCase(songName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Method to display the playlist
    public void displayThePlayList() {
        Node current = head;
        System.out.print("The playlist: ");
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }

    }

    //Method to insert a node at the beginning of the list
    public void addAtBeginning(String songName) {
        // Check the song is existed in the list or not
        if (checkSongExisted(songName)) {
            System.out.println("The song has already been in the playlist.");
        } else {
            Node newNode = new Node(songName); // create a new node with the given data
            newNode.next = head; // set the next reference of the new node to the current head
            head = newNode; // Update the head to the point to the new node
            System.out.println("The song has been added successfully!");
        }
        displayThePlayList();
    }

    //Method to insert a node at the end of the list
    public void addAtTheEnd(String songName) {
        // Check the song is existed in the list or not
        if (checkSongExisted(songName)) {
            System.out.println("The song has already been in the playlist.");
        } else {
            Node newNode = new Node(songName); // create a new node with the given data
            if (isEmpty()) { // if the list is empty, add the new node at beginning
                addAtBeginning(songName);
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next; // traverse the list until the last node
            }
            current.next = newNode; // Set the next reference of the last node to the new node
            newNode.next = null; // set the next reference of the new node to null to indicate that the last node is the new node
            System.out.println("The song has been added successfully!");
        }
        displayThePlayList();
    }

    //Method to remove a song from the list
    public void removeSong(String songName) {
        Node current = head;
        //Check the list is empty or not
        if (isEmpty()) { // If the list is empty
            System.out.println("Playlist is empty. Nothing to delete.");
            return;
        }
        // Check the song is existed in the list or not
        if (!checkSongExisted(songName)) { // Do not find the node to be deleted
            System.out.println("The music does not exist!");
            return;
        }

        if (head.data.equalsIgnoreCase(songName)) { // The music is the first music of the list
            if (hasOnlyOneNode()) {// If there is only one node in the list
                head = null;  // set the head to null, indicating an empty list
                System.out.println("The song has been removed successfully!");
                return;
            }
            head = head.next;
            System.out.println("The song has been removed successfully!");
            return;
        }

        while (current.next != null && !current.next.data.equalsIgnoreCase(songName)) 
        { //Traverse the list until the node just before the desired node 
            current = current.next;
        }
        current.next = current.next.next;
        System.out.println("The song has been removed successfully!");
    }

    //Method to search node by data
    //When call this method, checks for 'null' 
    public Node searchNode(String songName) {
        Node current = head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(songName)) {
                return current;
            }
            current = current.next;
        }
        return current;
    }

    //Method to skip to the next song
    public void skipToTheNext(String songName) {
        Node isPlaying = searchNode(songName);
        //If the list is empty
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } //Check the input music is existed in the list or not
        else if (isPlaying == null) {
            System.out.println("The music that you inputed does not exist!");
        } //If the list has only one node
        else if (hasOnlyOneNode()) {
            System.out.println("The list just has only one music. Can not skip to the next song!");
        } // If the music is playing is the last node
        else if (isPlaying.next == null) {
            System.out.println("Already at the last song, can't skip to next.");
        } else {
            isPlaying = isPlaying.next;   // Move to next node
            System.out.println("Now playing: " + isPlaying.data);

        }
    }

    //Method to skip to the previous song
    public void skipToThePrevious(String songName) {
        Node isPlaying = searchNode(songName);
        Node current = head;
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        } else if (isPlaying == null) {
            System.out.println("The music that you inputed does not exist!");
            return;
        } else if (hasOnlyOneNode()) {
            System.out.println("The list just has only one music.");
            return;
        } // If isPlaying is at the head
        else if (isPlaying == head) {
            System.out.println("Already at the first song, can't skip to previous. ");
        } else {
            // Traverse to find the node before isPlaying
            while (!current.next.data.equalsIgnoreCase(isPlaying.data)) {
                current = current.next;
            }
            //After the loop, the current node is the isPlaying's previous node
            System.out.println("Now playing: " + current.data);
        }
    }

    //Mehtod to count the number of elements in the playlist
    public int theNumOfSongs() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //Method to shuffle the playlist
    public void shuffleThePlaylist() {
        //Step 1: Convert the linked list to an ArrayList
        List<Node> nodeList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            nodeList.add(current);
            current = current.next;
        }
        //Step 2: Shuffle the ArrayList
        Collections.shuffle(nodeList);
        //Step 3: Rebuild the linked list from the shuffled Arraylist
        if (!nodeList.isEmpty()) {
            head = nodeList.get(0);
            current = head;
            //Start from the second element
            for (int i = 1; i < nodeList.size(); i++) {
                current.next = nodeList.get(i);
                current = current.next;
            }
            current.next = null;// The last node point to null
        }
        //Print the shuffed playlist
        displayThePlayList();
    }

}
