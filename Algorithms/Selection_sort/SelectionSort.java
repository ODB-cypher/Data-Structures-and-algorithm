/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms;

public class SelectionSort {
    // sort array in ascending order using selection sort
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // index of smallest in a[i..n-1]
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }
            if (minIdx != i) { // swap into position i
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
            }
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
        int[] arr = {29, 64, 12, 22, 11};
        System.out.print("Before: ");
        display(arr);

        selectionSort(arr);

        System.out.print("After:  ");
        display(arr);
    }
}
