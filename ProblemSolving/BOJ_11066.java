import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] sum = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][N + 1];
            for (int cnt = 1; cnt < N + 1; cnt++) {
                for (int start = 1; start + cnt < N + 1; start++) {
                    int end = start + cnt;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }
            sb.append(dp[1][N]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
