import java.util.*;

class Solution {
    
    private boolean[] visited; // 방문 배열 
    private List<String> answer; // 최종 답변
    private boolean finished = false; 
    
    public String[] solution(String[][] tickets) {
    
        int n = tickets.length;
        visited = new boolean[n];
        answer = new ArrayList<>();
        
        // tickets을 사전순으로 정렬
        // tickets 배열을 Comparator 기준으로 정렬하겠다는 의미.
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");   
        
        dfs("ICN", tickets, path, 0);
        
        return answer.toArray(new String[0]);
    
    }
    
     /* DFS 정의 */
     private void dfs(String cur, String[][] tickets, List<String> path, int count) {
        if (finished) return; // 이미 답을 찾았으면 더 탐색 안 함
        if (count == tickets.length) {
            answer = new ArrayList<>(path);
            finished = true;
            return; // return은 void 메서드인 dfs 메서드 자체를 빠져나간다.
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, count + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
    
 
    
}