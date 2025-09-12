package Algo.BFS;

import java.util.*;

/**
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 * 
 * 
 */

public class BFSExample2 {
    public static void main(String[] args) {

        int n = 5;

        // 인접 리스트 형태의 그래프를 저장하는 배열
        // 아직은 null 상태 -> 추후 초기화 필요
        List<Integer>[] graph = new ArrayList[n + 1];

        // 해당 노드 방문 여부
        boolean[] visited = new boolean[n + 1];

        // 각 정점마다 연결된 노드 초기화
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        // 그래프 연결 -> 무방향 연결 (서로 이동 가능)
        graph[1].add(2);
        graph[2].add(1);
        graph[1].add(3);
        graph[3].add(1);
        graph[2].add(4);
        graph[4].add(2);
        graph[2].add(5);
        graph[5].add(2);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            // 그래프 안에 있는 Value를 next에 대입
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); // 방문 안된 노드: -1
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        dist[1] = 0;

        while (!q1.isEmpty()) {
            int node = q1.poll();
            for (int next : graph[node]) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    q1.add(next);
                }
            }
        }

        System.out.println(Arrays.toString(dist));

    }
}
