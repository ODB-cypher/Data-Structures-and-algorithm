/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import java.util.ArrayDeque;
import java.util.Queue;

// Stack (LIFO) using two FIFO queues. push: O(1), pop/peek: O(n).
public class QueueStack<T> {
    private Queue<T> q1 = new ArrayDeque<>(); // main queue
    private Queue<T> q2 = new ArrayDeque<>(); // helper queue

    /** Push element onto the stack (top). */
    public void push(T x) {
        q1.offer(x);
        System.out.println("Pushed: " + x);
    }

    // Pop and return the top element; returns null if empty.
    public T pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        while (q1.size() > 1) q2.offer(q1.poll());
        T top = q1.poll();
        System.out.println("Popped: " + top);
        swapQueues();
        return top;
    }

    // Return the top element without removing it; null if empty.
    public T peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        while (q1.size() > 1) q2.offer(q1.poll());
        T top = q1.peek();
        q2.offer(q1.poll()); // put it back
        swapQueues();
        return top;
    }

    // True if the stack has no elements. 
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Number of elements in the stack. 
    public int size() {
        return q1.size();
    }

    // Print elements from bottom -> top. 
    public void display() {
        System.out.println("Stack (bottom -> top): " + q1);
    }

    // Swap helper and main queues. 
    private void swapQueues() {
        Queue<T> tmp = q1; q1 = q2; q2 = tmp;
    }

    public static void main(String[] args) {
        QueueStack<Integer> st = new QueueStack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();

        System.out.println("Peek: " + st.peek());
        st.display();

        st.pop();
        st.display();

        System.out.println("Size: " + st.size());
        System.out.println("Is empty? " + st.isEmpty());
    }
}
