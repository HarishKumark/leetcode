/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import java.util.ArrayList;

/**
 *
 * @author hkorada
 */
public class AdjacUndirectedWeighted {

    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {

        ArrayList<AdjacUndirectedWeighted.Edge> graph[] = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new AdjacUndirectedWeighted.Edge(0, 2, 2));

        graph[1].add(new AdjacUndirectedWeighted.Edge(1, 2, 10));
        graph[1].add(new AdjacUndirectedWeighted.Edge(1, 3, 0));

        graph[2].add(new AdjacUndirectedWeighted.Edge(2, 0, 2));
        graph[2].add(new AdjacUndirectedWeighted.Edge(2, 1, 10));
        graph[2].add(new AdjacUndirectedWeighted.Edge(2, 3, -1));

        graph[3].add(new AdjacUndirectedWeighted.Edge(3, 1, -1));
        graph[3].add(new AdjacUndirectedWeighted.Edge(3, 2, 3));

        System.out.println("Get neighbours ");

        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println(graph[2].get(i).dest + " , " + graph[2].get(i).weight);
        }
        System.out.println("");
    }
}
