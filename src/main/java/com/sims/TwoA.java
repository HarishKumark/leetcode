/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Scanner;

/**
 *
 * @author hkorada
 */
public class TwoA {

    public static void leftShift() {
        int n = 5;
        int pos = 3;
        int bitMask = 1 << pos;
        if (((bitMask & n) == 0)) {
            System.out.print("zero bit");
        } else {
            System.out.print("non zero bit");
        }
    }

    public static void main(String[] args) {
        leftShift();
    }

    public void twoArr() {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] numbers = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
