/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

public class ArrayStack<T> {
    // fixed-size array backing the stack
    private final Object[] a;
    // insert index / current size
    private int top;

    // default capacity
    public ArrayStack() {
        this(16);
    }

    // custom fixed capacity
    public ArrayStack(int capacity) {
        if (capacity < 1) capacity = 1;
        a = new Object[capacity];
        top = 0;
    }

    // push element to top; prints if full
    public void push(T x) {
        if (top == a.length) {
            System.out.println("Stack is full!");
            return;
        }
        a[top++] = x;
        System.out.println("Pushed: " + x);
    }

    // pop top element; null if empty
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T val = (T) a[--top];
        a[top] = null; // clear slot
        System.out.println("Popped: " + val);
        return val;
    }

    // peek top element; null if empty
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return (T) a[top - 1];
    }

    // true if no elements
    public boolean isEmpty() {
        return top == 0;
    }

    // number of elements
    public int size() {
        return top;
    }

    // print elements bottom 
    public void display() {
        System.out.print("Stack (bottom -> top): [");
        for (int i = 0; i < top; i++) {
            System.out.print(a[i]);
            if (i < top - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayStack<Integer> st = new ArrayStack<>(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();

        System.out.println("Peek: " + st.peek());
        st.display();

        st.pop();
        st.display();

        // full behavior
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70); // will print "Stack is full!"
        st.display();

        System.out.println("Size: " + st.size());
        System.out.println("Is empty? " + st.isEmpty());
    }
}
