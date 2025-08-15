/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import java.util.ArrayDeque;
import java.util.Deque;

public class LIFOQueueUsingDeque<T> {
    private Deque<T> deque = new ArrayDeque<>();

    public void push(T element) {
        deque.addFirst(element);
        System.out.println("Pushed: " + element);
    }

    public T pop() {
        if (deque.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return deque.removeFirst();
    }

    public void display() {
        System.out.println("Queue: " + deque);
    }

    public static void main(String[] args) {
        LIFOQueueUsingDeque<Integer> lifo = new LIFOQueueUsingDeque<>();
        lifo.push(10);
        lifo.push(20);
        lifo.push(30);

        lifo.display();
        System.out.println("Popped: " + lifo.pop());
        lifo.display();
    }
}
