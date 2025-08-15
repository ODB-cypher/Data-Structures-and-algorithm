/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

public class ListStack {
    // node for singly linked list
    private static class Node {
        int val;
        Node next;
        Node(int v, Node n) { val = v; next = n; }
    }

    // top of stack and current size
    private Node head;
    private int size;

    // push value onto top
    public void push(int x) {
        head = new Node(x, head);
        size++;
        System.out.println("Pushed: " + x);
    }

    // pop top; returns null if empty
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        int v = head.val;
        head = head.next;
        size--;
        System.out.println("Popped: " + v);
        return v;
    }

    // peek top; returns null if empty
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return head.val;
    }

    // true if no elements
    public boolean isEmpty() {
        return head == null;
    }

    // number of elements
    public int size() {
        return size;
    }

    // print elements top -> bottom
    public void display() {
        System.out.print("Stack (top -> bottom): [");
        Node cur = head;
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
        ListStack st = new ListStack();
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
