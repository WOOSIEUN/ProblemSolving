import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] maze = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int jump = 1; jump <= maze[i] && i + jump < N; jump++) {
                dp[i + jump] = Math.min(dp[i + jump], dp[i] + 1);
            }
        }

        bw.write(String.valueOf(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]));
        br.close();
        bw.close();
    }
}
