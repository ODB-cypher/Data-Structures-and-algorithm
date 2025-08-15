/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class StackQueue {
    // stack for incoming elements
    private Deque<Integer> inStack = new ArrayDeque<>();
    // stack for outgoing elements
    private Deque<Integer> outStack = new ArrayDeque<>();

    // add to rear
    public void enqueue(Integer x) {
        inStack.push(x);
        System.out.println("Enqueued: " + x);
    }

    // remove from front; null if empty
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        moveIfNeeded();
        Integer val = outStack.pop();
        System.out.println("Dequeued: " + val);
        return val;
    }

    // view front; null if empty
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        moveIfNeeded();
        return outStack.peek();
    }

    // true if no elements
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // number of elements
    public int size() {
        return inStack.size() + outStack.size();
    }

    // print front -> rear
    public void display() {
        System.out.print("Queue (front -> rear): [");
        boolean first = true;

        for (Integer x : outStack) {
            if (!first) System.out.print(", ");
            System.out.print(x);
            first = false;
        }

        // use iterator explicitly for descending order
        Iterator<Integer> it = inStack.descendingIterator();
        while (it.hasNext()) {
            Integer x = it.next();
            if (!first) System.out.print(", ");
            System.out.print(x);
            first = false;
        }

        System.out.println("]");
    }

    // move elements to outStack if needed
    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    // demo
    public static void main(String[] args) {
        StackQueue q = new StackQueue();
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