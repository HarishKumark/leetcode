/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leetcode.dailychallenge.leetcodedaily;

/**
 *
 * @author Admin
 */
public class ServersCount_1267 {

    public int countServers(int[][] grid) {

        int[] row = new int[grid.length];
        int[] columns = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] += grid[i][j];
                columns[j] += grid[i][j];
            }
        }

        int serversCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || columns[j] > 1)) {
                    serversCount++;
                }
            }
        }
        return serversCount;
    }

    public static void main(String[] args) {
        System.out.println(new ServersCount_1267().countServers(new int[][]{{1, 0}, {1, 1}}));
    }
}
