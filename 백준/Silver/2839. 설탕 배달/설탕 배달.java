import java.util.*;

/* 최소 봉지 수를 찾고 싶음 → 조합 문제 + 최적화 문제 */
class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        int INF = 5001; // N 최대 5000이므로 충분히 큰 값
        int[] dp = new int[N + 1];

        // 초기화
        dp[0] = 0; // 0kg은 봉지 0개
        for (int i = 1; i <= N; i++) {
            dp[i] = INF; // 처음에는 불가능
        }

        // DP 채우기
        for (int i = 3; i <= N; i++) {
            if (dp[i - 3] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5 && dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[N] == INF ? -1 : dp[N]);

    }

}