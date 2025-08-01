/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedHashSetSequencedSet;

import java.util.HashSet;

public class LinkedHashSetSequencedSet {

    // Node class to maintain insertion order
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;                    // Head of linked list
    private Node tail;                    // Tail of linked list (for fast appends)
    private HashSet<Integer> hashSet;     // HashSet for fast uniqueness checks
    private int size = 0;                 // Tracks number of unique elements

    // Constructor
    public LinkedHashSetSequencedSet() {
        hashSet = new HashSet<>();
    }

    // Add value to the set if not already present
    public void add(int value) {
        if (!hashSet.contains(value)) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            hashSet.add(value);
            size++;
        }
    }

    // Remove value if it exists
    public boolean remove(int value) {
        if (!hashSet.contains(value)) {
            return false;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == value) {
                if (prev == null) {
                    head = current.next; // remove head
                } else {
                    prev.next = current.next;
                }
                if (current == tail) {
                    tail = prev; // update tail if needed
                }
                hashSet.remove(value);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    // Check if set contains a value
    public boolean contains(int value) {
        return hashSet.contains(value);
    }

    // Get size of the set
    public int size() {
        return size;
    }

    // Print all elements in insertion order
    public void printAll() {
        Node current = head;
        if (current == null) {
            System.out.println("Set is empty");
        } else {
            System.out.print("Set Elements: ");
            while (current != null) {
                System.out.print(current.data + "   ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        LinkedHashSetSequencedSet set = new LinkedHashSetSequencedSet();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // duplicate

        set.printAll(); // 10   20   30

        set.remove(20);
        set.printAll(); // 10   30

        System.out.println("Contains 30? " + set.contains(30)); // true
        System.out.println("Set size: " + set.size()); // 2

        set.remove(10);
        set.remove(30);
        set.printAll(); // Set is empty
    }
}
