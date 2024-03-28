/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hkorada
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public boolean hasNext() {
        
        return false;
    }

    @Override
    public Integer next() {
        return 0;
    }

    private static class NestedInteger {

        public NestedInteger() {
        }
    }
    
    
    public static void main(String[] args) {
        
    }

}
