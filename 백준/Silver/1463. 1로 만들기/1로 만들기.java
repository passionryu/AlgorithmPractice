import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // 초깃값 설정
        int[] dp = new int[N + 1];
        dp[1] = 0;

        // 점화식 설정
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1 빼기
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);

    }

}