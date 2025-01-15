/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class MinimizeXOR_2429 {

    public int minimizeXor(int num1, int num2) {

        int num1BitCount = Integer.bitCount(num1);
        int num2BitCount = Integer.bitCount(num2);

        while (num1BitCount != num2BitCount) {
            if (num1BitCount < num2BitCount) {
                num1++;
            } else {
                num1--;
            }
            num1BitCount = Integer.bitCount(num1);
        }
        return num1;
    }

    public static void main(String[] args) {

        MinimizeXOR_2429 minimizeXOR_2429 = new MinimizeXOR_2429();

        System.out.println(minimizeXOR_2429.minimizeXor(1, 12));
        System.out.println(minimizeXOR_2429.minimizeXor(3, 5));

    }

}
