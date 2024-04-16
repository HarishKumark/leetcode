/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sims;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hkorada
 */
public class TestBinary {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
        }

    }

    public static Node buildTree(int node[]) {

        if (node == null || node.length == 0) {

        }

        Node root = new Node(node[0]);
        Queue<Node> queueNode = new LinkedList<>();
        queueNode.add(root);
        

        int i = 1;
        while (i < node.length) {
            Node peek = queueNode.peek();
            Node curr = queueNode.remove();
           
            if (i < node.length) {
                curr.left = new Node(node[i++]);
                queueNode.add(curr.left);
            }

            if (i < node.length) {
                curr.right = new Node(node[i++]);
                queueNode.add(curr.right);
            }

        }

        System.out.println(queueNode);
        return root;
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) {
//            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node buildTree = buildTree(new int[]{4, 2, 6, 3, 1, 5});
//        System.out.println(buildTree.data);
        printTree(buildTree);
//        System.out.println(buildTree.data);

//        preOrder(root);
    }
}
