/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hkorada
 */
public class BinaryTree {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    static class BinaryTreeI {

        static int idx = -1;

        public static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    //preorder traversal
    // root - left - right
    public static void preOrder(Node root) {
        if (root == null) {
//            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Inorder traversal
    // left - root - right
    public static void Inorder(Node root) {
        if (root == null) {
//            System.out.print("-1 ");
            return;
        }
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);
    }

    //post order traversal
    // left - right - root 
    public static void postOrder(Node root) {
        if (root == null) {
//            System.out.print("-1 ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //level order
    /*
       1
     2   3
    4 5   6
    
    o/p : 1
          2 3
          4 5 6
     */
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);

        while (!que.isEmpty()) {
            Node currNode = que.remove();
            if (currNode == null) {
                System.out.println();
                if (que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    que.add(currNode.left);
                }
                if (currNode.right != null) {
                    que.add(currNode.right);
                }
            }

        }
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int countOfLeftNodes = countOfNodes(root.left);
        int countOfRightNodes = countOfNodes(root.right);
        return countOfLeftNodes + countOfRightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int countOfLeftNodes = sumOfNodes(root.left);
        int countOfRightNodes = sumOfNodes(root.right);
        return countOfLeftNodes + countOfRightNodes + root.data;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root) {
        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);
        int diam = height(root.left) + height(root.right) + 1;
        return Math.max(diam, Math.max(diameterLeft, diameterRight));
    }

    static class TreeInfo {

        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

    }

    public static TreeInfo diameter2(Node root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo diameterLeft = diameter2(root.left);
        TreeInfo diameterRight = diameter2(root.right);

        int max = Math.max(diameterLeft.height, diameterRight.height) + 1;

        int diam1 = diameterLeft.diameter;
        int diam2 = diameterLeft.diameter;
        int diam3 = diameterLeft.height + diameterRight.height + 1;

        int max1 = Math.max(Math.max(diam1, diam2), diam3);
        TreeInfo my = new TreeInfo(max, max1);
        return my;
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null & subroot == null) {
            return true;
        }

        if (root == null || subroot == null) {
            return false;
        }

        if (root.data == subroot.data) {
            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }
        return false;

    }

    public static boolean isSubtree(Node root, Node subroot) {

        if (subroot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            return isIdentical(root, subroot);
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

    }

    public static void sumOfValues(Node root, int k) {
        if (root == null) {
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int count = 0, sum = 0;
        while (!que.isEmpty()) {
            
            count++;

            Node currNode = que.remove();

            if (currNode == null) {
                System.out.println();
                if (que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
            } else {
                
                if (k == count) {
                    sum += currNode.data;
                }
                
                
                System.out.print(currNode.data + " ");
                
                if (currNode.left != null) {
                    que.add(currNode.left);
                }
                if (currNode.right != null) {
                    que.add(currNode.right);
                }
            }
        }
        System.out.println("sum=== " + sum);
//        return sum;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTreeI tree = new BinaryTreeI();
        Node root = tree.buildTree(nodes);

        System.out.println("root " + root.data);
//        Inorder(root);
//        postOrder(root);
//        levelOrder(root);
        int count = 0, sum = 0;
        System.out.println("countOfNodes " + countOfNodes(root));
        System.out.println("sumOfNodes " + sumOfNodes(root));
        System.out.println("height " + height(root)); //big(n)
        System.out.println("diameter2 " + diameter2(root).diameter); //big(n)
        sumOfValues(root, 2);
        System.out.println("sumOfValues " + sum); //big(n)

    }
}
