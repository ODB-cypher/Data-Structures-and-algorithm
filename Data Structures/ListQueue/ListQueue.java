/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

public class ListQueue {
    // node of singly linked list
    private static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    // front (head), rear (tail), and size
    private Node front;
    private Node rear;
    private int size;

    // add to rear
    public void enqueue(int x) {
        Node n = new Node(x);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        size++;
        System.out.println("Enqueued: " + x);
    }

    // remove from front; null if empty
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        int v = front.val;
        front = front.next;
        if (front == null) rear = null;
        size--;
        System.out.println("Dequeued: " + v);
        return v;
    }

    // view front; null if empty
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.val;
    }

    // true if no elements
    public boolean isEmpty() {
        return front == null;
    }

    // number of elements
    public int size() {
        return size;
    }

    // print front -> rear
    public void display() {
        System.out.print("Queue (front -> rear): [");
        Node cur = front;
        boolean first = true;
        while (cur != null) {
            if (!first) System.out.print(", ");
            System.out.print(cur.val);
            first = false;
            cur = cur.next;
        }
        System.out.println("]");
    }

    // demo
    public static void main(String[] args) {
        ListQueue q = new ListQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Peek: " + q.peek());
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Size: " + q.size());
        System.out.println("Is empty? " + q.isEmpty());
    }
}
