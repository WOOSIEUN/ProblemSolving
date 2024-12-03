import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];

            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                int num = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i - 1] + num, num);
                max = Math.max(dp[i], max);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
