/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class CheckParantheses_2116 {

    public boolean canBeValid(String s, String locked) {

        if (s.length() % 2 != 0) {
            return false;
        }

        int openingCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                openingCount++;
            } else {
                openingCount--;
            }
            if (openingCount < 0) {
                return false;
            }

        }
        int closingCount = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                closingCount++;
            } else {
                closingCount--;
            }
            if (closingCount < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckParantheses_2116 checkParantheses_2116 = new CheckParantheses_2116();

        System.out.println(checkParantheses_2116.canBeValid("))()))", "010100"));
        System.out.println(checkParantheses_2116.canBeValid(")", "0"));

    }

}
