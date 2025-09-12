import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    // 상하 좌우에 대한 배열 
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        // 배열의 행의 크기 
        int n = maps.length;
        // 배열의 한 열의 크기 
        int m = maps[0].length;
        // visited 배열은 T,F 값으로 저장 
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작점, 거리 1
        visited[0][0] = true; // 시작점은 true로 방문 처리 완료 
        
        // bfs 호출 
        return bfs(maps, queue, visited, n, m);
    }
    
    private int bfs(int[][] maps, Queue<int[]> queue, boolean[][] visited, int n, int m) {
        
        // 큐에 값이 존재하면 
        while (!queue.isEmpty()) {
            
            int[] cur = queue.poll(); // 큐에서 값을 꺼낸다 
            int x = cur[0]; // 0번 인덱스 : x 좌표 
            int y = cur[1]; // 1번 인덱스 : y 좌표 
            int dist = cur[2]; // 해당 좌표의 거리 
            
            if (x == n - 1 && y == m - 1) return dist; // 만약, x,y좌표가 마감점일때는 거리를 반환 
            
            // 전방위로 1칸 씩 전진 
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 배열의 범주를 넘어가면 continue
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; 
                // 벽이거나, 방문한 것이면 continue 
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                // 그게 아니면, 방문 처리
                visited[nx][ny] = true;
                
                // 큐에 현재 좌표와 거리를 더한다
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }
        // 위 조건에 안 걸리면 -1 반환 
        return -1;
    }
    
//     public int solution(int[][] maps) {
//         int rows = maps.length;
//         int cols = maps[0].length;

//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0, 0, 1}); // 시작 위치와 거리

//         while (!queue.isEmpty()) {
//             int[] current = queue.poll();
//             int row = current[0];
//             int col = current[1];
//             int distance = current[2];

//             if (row == rows - 1 && col == cols - 1) {
//                 return distance; // 목적지에 도달한 경우 최단거리 반환
//             }

//             for (int[] dir : directions) {
//                 int newRow = row + dir[0];
//                 int newCol = col + dir[1];

//                 if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maps[newRow][newCol] == 1) {
//                     maps[newRow][newCol] = 0; // 방문한 위치는 재방문하지 않도록 표시
//                     queue.offer(new int[]{newRow, newCol, distance + 1});
//                 }
//             }
//         }

//         return -1; // 목적지에 도달하지 못한 경우
//     }
    
}