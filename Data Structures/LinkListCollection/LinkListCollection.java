/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linklistcollection;

/**
 *
 * @author ASUS
 */
public class LinkListCollection {

    /**
     * @param args the command line arguments
     */
    private Node head;
    private int size = 0;

    // Node inner class
    private static class Node {
        int data;
        Node next;

        //initially node doesnt point to any other node
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
        //each time an element is added list size is increased by 1
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

    // Return the size
    public int size() {
        return size;
    }

    // Print all elements in the list
    public void printAll() {
        Node current = head;
        
        //If the list is empt
        if(current==null){
            System.out.println("List is empty");
        }
        
        while (current != null) {
            System.out.print(current.data + "   ");
            current = current.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        LinkListCollection list = new LinkListCollection();

        list.add(10);
        list.add(20);
        list.add(30);

        list.printAll(); 

        list.remove(20);
        list.printAll(); 

        System.out.println("Element at index 1: " + list.get(1)); // 30
        System.out.println("List size: " + list.size()); // 2
        
        
        list.remove(10);
        list.remove(30);
        
        list.printAll();
    }
    
}
