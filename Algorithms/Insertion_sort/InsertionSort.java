/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms;

public class InsertionSort {
    // sort array in ascending order using insertion sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];        // element to insert
            int j = i - 1;         // last index of sorted part
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];   // shift right
                j--;
            }
            a[j + 1] = key;        // place key
        }
    }

    // print array as [a, b, c]
    public static void display(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // demo
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.print("Before: ");
        display(arr);

        insertionSort(arr);

        System.out.print("After:  ");
        display(arr);
    }
}
