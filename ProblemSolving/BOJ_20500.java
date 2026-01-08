import java.io.*;

public class BOJ_20500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MOD = 1_000_000_007;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[3][N + 1];
        if (N > 1) {
            dp[0][2] = 1;
            dp[1][2] = 1;
        }

        for (int i = 3; i < N + 1; i++) {
            dp[0][i] = (dp[2][i - 1] + dp[1][i - 1]) % MOD;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
            dp[2][i] = (dp[1][i - 1] + dp[0][i - 1]) % MOD;
        }

        bw.write(String.valueOf(dp[0][N]));
        br.close();
        bw.close();
    }
}
