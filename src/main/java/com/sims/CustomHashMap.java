/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Arrays;

/**
 *
 * @author hkorada
 */
public class CustomHashMap {

    int[] map = new int[1000001];

    public CustomHashMap() {
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;

    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
