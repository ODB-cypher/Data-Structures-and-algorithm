package HashSetSet;
import java.util.LinkedList;

/**
 * A simple custom HashSet implementation for integers.
 * Uses hashing with separate chaining to store unique values.
 */
public class HashSetSet {

    // Total number of buckets (fixed-size array)
    private static final int INITIAL_CAPACITY = 16;

    // Array of LinkedLists to handle collisions (separate chaining)
    private LinkedList<Integer>[] buckets;

    // Total number of unique elements stored
    private int size = 0;

    // Constructor: initialize all buckets as empty linked lists
    public HashSetSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function: maps a key to a bucket index within array bounds
    // Math.abs handles negative numbers, and % keeps index in range
    private int getBucketIndex(int key) {
        return Math.abs(key) % buckets.length;
    }

    // Add a value to the set if it's not already present
    public void add(int value) {
        int index = getBucketIndex(value);              // Find the bucket index
        LinkedList<Integer> bucket = buckets[index];    // Get the corresponding bucket
        if (!bucket.contains(value)) {                  // Only add if not already present
            bucket.add(value);
            size++;
        }
    }

    // Remove a value from the set if present
    public boolean remove(int value) {
        int index = getBucketIndex(value);              // Locate the correct bucket
        LinkedList<Integer> bucket = buckets[index];
        if (bucket.remove((Integer) value)) {           // Remove if found
            size--;
            return true;
        }
        return false;                                   // Return false if value not found
    }

    // Check if a value exists in the set
    public boolean contains(int value) {
        int index = getBucketIndex(value);
        return buckets[index].contains(value);
    }

    // Return the total number of elements in the set
    public int size() {
        return size;
    }

    // Print all elements in the set
    public void printAll() {
        System.out.print("HashSet Elements: ");
        boolean isEmpty = true;

        // Iterate through all buckets and print values
        for (LinkedList<Integer> bucket : buckets) {
            for (int val : bucket) {
                System.out.print(val + " ");
                isEmpty = false;
            }
        }

        // If no elements found
        if (isEmpty) {
            System.out.println("Set is empty");
        } else {
            System.out.println();
        }
    }

    // Main method to test functionality
    public static void main(String[] args) {
        HashSetSet set = new HashSetSet();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Duplicate, will not be added

        set.printAll(); // Output: 10 20 30

        System.out.println("Contains 20? " + set.contains(20)); // true
        System.out.println("Removing 20: " + set.remove(20));   // true
        System.out.println("Contains 20? " + set.contains(20)); // false

        set.printAll(); // Output: 10 30

        System.out.println("Size of set: " + set.size()); // 2

        set.remove(10);
        set.remove(30);
        set.printAll(); // Set is empty
    }
}
