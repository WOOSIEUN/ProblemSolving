import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] roads = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            if (roads[i - 1] < roads[i]) {
                dp[i] = dp[i - 1] + (roads[i] - roads[i - 1]);
            }
            ans = Math.max(ans, dp[i]);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
