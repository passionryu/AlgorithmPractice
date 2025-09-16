import java.util.*;

class Solution {
  
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        
         for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
     
    /* BFS 구현 */
    private void bfs(int start,int[][] computers, boolean[] visited){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next = 0; next < computers.length; next++) {
                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }    
    }
}