/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

/**
 *
 * @author hkorada
 */
public class Leet {

    public void slidingWindow(int[] nums, int sliding) {
        for (int i = 0; i < nums.length; i++) {
            if (sliding + i <= nums.length) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j < sliding + i; j++) {
                    int num = nums[j];
                    if (max < num) {
                        max = num;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Leet leet = new Leet();

        leet.slidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }
}
