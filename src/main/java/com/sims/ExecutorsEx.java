/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author hkorada
 */
public class ExecutorsEx {

    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            newFixedThreadPool.submit(() -> {
                // This is the task to be executed in a separate thread
                System.out.println("Task " + taskNumber + " is running on thread: " + Thread.currentThread().getId());
            });
        }

        newFixedThreadPool.shutdown();

    }
}
