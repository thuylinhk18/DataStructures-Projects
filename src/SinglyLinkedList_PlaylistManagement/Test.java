/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList_PlaylistManagement;

import java.util.Scanner;

/**
 *
 * @author bebet
 */
public class Test {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\nMenu");
            System.out.println("1. List the playlist");
            System.out.println("2. Add song at the beginning of the playlist");
            System.out.println("3. Add song at the end of the playlist");
            System.out.println("4. Remove song");
            System.out.println("5. Song counter");
            System.out.println("6. Skip to the next song");
            System.out.println("7. Skip to the previous song");
            System.out.println("8. Suffle the playlist");
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
                    playlist.displayThePlayList();
                    break;
                case 2:
                    System.out.print("Enter song to add: ");
                    String songToAddAtTheBeginning = scanner.nextLine();
                    playlist.addAtBeginning(songToAddAtTheBeginning);
                    break;
                case 3:
                    System.out.print("Enter song to add: ");
                    String songToAddAtTheEnd = scanner.nextLine();
                    playlist.addAtTheEnd(songToAddAtTheEnd);
                    break;
                case 4:
                    System.out.print("Enter song to remove: ");
                    String songToRemove = scanner.nextLine();
                    playlist.removeSong(songToRemove);
                    playlist.displayThePlayList();
                    break;
                case 5:
                    System.out.println("The number of songs in the playlist is: " + playlist.theNumOfSongs());
                    break;
                case 6:
                    playlist.displayThePlayList();
                    System.out.print("\nEnter the is song is playing ");
                    String songNameToSkipNext = scanner.nextLine();
                    playlist.skipToTheNext(songNameToSkipNext);
                    break;
                case 7:
                    playlist.displayThePlayList();
                    System.out.print("\nEnter the is song is playing ");
                    String songNameToSkipPrevious = scanner.nextLine();
                    playlist.skipToThePrevious(songNameToSkipPrevious);
                    break;
                case 8:
                    playlist.shuffleThePlaylist();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println("\n================================================");
        } while (choice != 0);
        scanner.close();
    }

}
