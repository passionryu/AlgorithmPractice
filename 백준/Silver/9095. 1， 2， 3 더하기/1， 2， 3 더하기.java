import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] dp = new int[n + 1];

            dp[1] = 1;
            if (n >= 2) dp[2] = 2;
            if (n >= 3) dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        }

        scanner.close();
    }
}
