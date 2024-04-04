/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hkorada
 */
public class DepthFirstSearch {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[7];
        createGraph(graph);
        boolean[] vis = new boolean[graph.length];
        DFS(graph, 0, vis);

    }

    public static void DFS(ArrayList<Edge> graph[], int currentNode, boolean[] vis) {
        if (!vis[currentNode]) {
            System.out.print(currentNode+" ");
            vis[currentNode] = true;
            for (int i = 0; i < graph[currentNode].size(); i++) {
                Edge get = graph[currentNode].get(i);
                DFS(graph, get.dest, vis);
            }
        }

//        Queue<Integer> q = new LinkedList<>();
//        while (!q.isEmpty()) {
//            Integer currentNode = q.remove();
//        }
    }
}
