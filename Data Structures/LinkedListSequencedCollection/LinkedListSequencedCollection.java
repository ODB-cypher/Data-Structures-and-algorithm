/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linklistcollection;

/**
 *
 * @author ASUS
 */
public class LinkedListSequencedCollection {

    /**
     * @param args the command line arguments
     */
    private Node head;
    private int size = 0;

    // Node inner class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Add element to the end of list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Insert element at a specific index
    public void insertAt(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Remove first occurrence of value
    public boolean remove(int data) {
        if (head == null) return false;

        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        size--;
        return true;
    }

    // Get element at index
    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Return size
    public int size() {
        return size;
    }

    // Print all elements
    public void printAll() {
        Node current = head;

        if (current == null) {
            System.out.println("List is empty");
        }

        while (current != null) {
            System.out.print(current.data + "   ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedListSequencedCollection list = new LinkedListSequencedCollection();

        list.add(10);
        list.add(30);
        list.printAll(); // 10   30

        list.insertAt(1, 20); // Insert 20 between 10 and 30
        list.printAll(); // 10   20   30

        list.remove(10);
        list.printAll(); // 20   30

        System.out.println("Element at index 1: " + list.get(1)); // 30
        System.out.println("List size: " + list.size()); // 2

        list.remove(20);
        list.remove(30);
        list.printAll(); // List is empty
    }
}
