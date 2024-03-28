/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

/**
 *
 * @author hkorada
 */
public class Sorting {

    public static void main(String[] args) {
        //bubbleSort();
        selectionSort();
    }

    public static void selectionSort() {
        int arr[] = {7, 8, 3, 1, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("arr[smallest] "+arr[smallest] +" "+arr[j] +" , j "+j +" i = "+i);
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            System.out.println(smallest);
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void bubbleSort() {
        int arr[] = {7, 8, 3, 1, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
