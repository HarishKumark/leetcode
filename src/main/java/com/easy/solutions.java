/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easy;

/**
 *
 * @author Admin
 */
public class solutions {

    public static void main(String[] args) {

        String input = "edcba";
        String res = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            res += input.charAt(i);
        }
        System.out.println(res);
    }
}
