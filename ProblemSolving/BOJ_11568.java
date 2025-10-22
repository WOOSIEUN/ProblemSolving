import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        int max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int cur = 0; cur < N; cur++) {
            nums[cur] = Integer.parseInt(st.nextToken());
            dp[cur] = 1;
            for (int prev = 0; prev < cur; prev++) {
                if (nums[prev] < nums[cur]) {
                    dp[cur] = Math.max(dp[cur], dp[prev] + 1);
                }
            }
            max = Math.max(max, dp[cur]);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
