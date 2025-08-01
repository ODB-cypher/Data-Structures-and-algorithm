/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PriorityQueue;

public class PriorityQueue {

    // Node class representing each item in the queue
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;      // Head of the queue (smallest value)
    private int size = 0;   // Number of elements in the queue

    // Add element in sorted order (ascending)
    public void add(int value) {
        Node newNode = new Node(value);

        // If queue is empty or new node has highest priority
        if (head == null || value < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data <= value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Remove and return the highest priority element (smallest number)
    public int poll() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    // Peek at the highest priority element without removing it
    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    // Return number of elements in the queue
    public int size() {
        return size;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print all elements in priority order
    public void printAll() {
        Node current = head;

        if (current == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Priority Queue Elements: ");
        while (current != null) {
            System.out.print(current.data + "   ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        queue.add(30);
        queue.add(10);
        queue.add(20);
        queue.add(5);

        queue.printAll(); // 5   10   20   30

        System.out.println("Peek: " + queue.peek()); // 5
        System.out.println("Poll: " + queue.poll()); // 5
        queue.printAll(); // 10   20   30

        System.out.println("Queue size: " + queue.size()); // 3

        queue.poll(); queue.poll(); queue.poll();
        queue.printAll(); // Queue is empty
    }
}
