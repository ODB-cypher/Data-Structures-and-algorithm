/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms;

public class BubbleSort {
    // sort array in ascending order using bubble sort
    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // stop early if already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) { // swap adjacent if out of order
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // no swaps => sorted
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
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Before: ");
        display(arr);

        bubbleSort(arr);

        System.out.print("After:  ");
        display(arr);
    }
}