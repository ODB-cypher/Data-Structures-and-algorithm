/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

public class ArrayList {
    // backing array
    private int[] a;
    // current number of elements
    private int size;

    // default capacity
    public ArrayList() {
        this(10);
    }

    // custom initial capacity
    public ArrayList(int capacity) {
        if (capacity < 1) capacity = 1;
        a = new int[capacity];
        size = 0;
    }

    // add to end
    public void add(int e) {
        ensureCapacity(size + 1);
        a[size++] = e;
    }

    // insert at index
    public void add(int index, int e) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            a[i] = a[i - 1]; // shift right
        }
        a[index] = e;
        size++;
    }

    // get at index
    public int get(int index) {
        checkIndex(index);
        return a[index];
    }

    // set at index, return old value
    public int set(int index, int e) {
        checkIndex(index);
        int old = a[index];
        a[index] = e;
        return old;
    }

    // remove at index, return removed value
    public int remove(int index) {
        checkIndex(index);
        int old = a[index];
        for (int i = index; i < size - 1; i++) {
            a[i] = a[i + 1]; // shift left
        }
        size--;
        return old;
    }

    // remove first occurrence, return true if removed
    public boolean removeValue(int e) {
        int i = indexOf(e);
        if (i == -1) return false;
        remove(i);
        return true;
    }

    // first index of element, -1 if not found
    public int indexOf(int e) {
        for (int i = 0; i < size; i++) {
            if (a[i] == e) return i;
        }
        return -1;
    }

    // contains element
    public boolean contains(int e) {
        return indexOf(e) != -1;
    }

    // current size
    public int size() {
        return size;
    }

    // true if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // remove all elements
    public void clear() {
        size = 0;
    }

    // print elements as [a, b, c]
    public void display() {
        System.out.print("ArrayList: [");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ensure space, simple grow with manual copy
    private void ensureCapacity(int minCap) {
        if (minCap <= a.length) return;
        int newCap = Math.max(a.length * 2, minCap);
        int[] b = new int[newCap];
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
        a = b;
    }

    // check index for get/set/remove
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // check index for add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // demo
    public static void main(String[] args) {
        ArrayList list = new ArrayList(3);
        list.add(10);
        list.add(20);
        list.add(30);
        list.display();

        list.add(1, 15);
        list.display();

        System.out.println("get(2): " + list.get(2));
        System.out.println("set(2, 99) old: " + list.set(2, 99));
        list.display();

        System.out.println("remove index 1: " + list.remove(1));
        list.display();

        System.out.println("remove value 99: " + list.removeValue(99));
        list.display();

        System.out.println("contains 10? " + list.contains(10));
        System.out.println("indexOf 10: " + list.indexOf(10));
        System.out.println("size: " + list.size());
    }
}
