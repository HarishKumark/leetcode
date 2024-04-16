/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import static graphs.DepthFirstSearch.createGraph;
import java.util.ArrayList;

/**
 *
 * @author hkorada
 */
public class PathMovement {

    public static void createGraph(ArrayList<DepthFirstSearch.Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new DepthFirstSearch.Edge(0, 1));
        graph[0].add(new DepthFirstSearch.Edge(0, 2));

        graph[1].add(new DepthFirstSearch.Edge(1, 0));
        graph[1].add(new DepthFirstSearch.Edge(1, 3));

        graph[2].add(new DepthFirstSearch.Edge(2, 0));
        graph[2].add(new DepthFirstSearch.Edge(2, 4));

        graph[3].add(new DepthFirstSearch.Edge(3, 1));
        graph[3].add(new DepthFirstSearch.Edge(3, 4));
        graph[3].add(new DepthFirstSearch.Edge(3, 5));

        graph[4].add(new DepthFirstSearch.Edge(4, 2));
        graph[4].add(new DepthFirstSearch.Edge(4, 3));
        graph[4].add(new DepthFirstSearch.Edge(4, 5));

        graph[5].add(new DepthFirstSearch.Edge(5, 3));
        graph[5].add(new DepthFirstSearch.Edge(5, 4));
        graph[5].add(new DepthFirstSearch.Edge(5, 6));

        graph[6].add(new DepthFirstSearch.Edge(6, 5));

    }

    public static void main(String[] args) {

        ArrayList<DepthFirstSearch.Edge> graph[] = new ArrayList[7];
        createGraph(graph);

        boolean[] vis = new boolean[graph.length];

        DFS(graph, 0, vis, "0->", 5);

    }

    //o(V^V)
    public static void DFS(ArrayList<DepthFirstSearch.Edge> graph[], int currentNode, boolean[] vis, String path, int targetNode) {
        if (currentNode == targetNode) {
            System.out.println(path );
            return;
        }

        for (int i = 0; i < graph[currentNode].size(); i++) {
            DepthFirstSearch.Edge get = graph[currentNode].get(i);
            if (!vis[get.dest]) {
                vis[currentNode] = true;
                DFS(graph, get.dest, vis, path + get.dest+"->", targetNode);
                vis[currentNode] = false;
            }
        }

    }
}
