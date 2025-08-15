/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import java.util.ArrayDeque;
import java.util.Deque;

public class FIFOQueueUsingDeque<T> {
    // underlying deque
    private Deque<T> deque = new ArrayDeque<>();

    // add to rear
    public void enqueue(T x) {
        deque.addLast(x);
        System.out.println("Enqueued: " + x);
    }

    // remove from front; null if empty
    public T dequeue() {
        if (deque.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T val = deque.removeFirst();
        System.out.println("Dequeued: " + val);
        return val;
    }

    // view front; null if empty
    public T peek() {
        if (deque.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return deque.peekFirst();
    }

    // true if empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // number of elements
    public int size() {
        return deque.size();
    }

    // print front -> rear
    public void display() {
        System.out.println("Queue (front -> rear): " + deque);
    }

    // demo
    public static void main(String[] args) {
        FIFOQueueUsingDeque<Integer> q = new FIFOQueueUsingDeque<>();
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
