package Algo.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSBasic {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " "); // 방문 출력

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        // 간단한 그래프 (1-2-3-4-5)
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(4);
        graph[4].add(3);
        graph[4].add(5);
        graph[5].add(4);

        bfs(1); // 출력: 1 2 3 4 5
    }
}
