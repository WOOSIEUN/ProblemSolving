import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int [N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int [M + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int money = coin; money < dp.length; money++) {
                    dp[money] += dp[money - coin];
                }
            }
            sb.append(dp[M]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
