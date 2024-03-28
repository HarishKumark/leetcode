/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

/**
 *
 * @author hkorada
 */
public abstract class BackgroundThreadRunner<T> implements Runnable, Function {

    protected T object;
    private Thread thread;

    @Override
    public void run() {
        try {
            function();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
