import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] counseling = new int[N + 2][2];
        for (int i = 1; i < counseling.length - 1; i++) {
            st = new StringTokenizer(br.readLine());
            counseling[i][0] = Integer.parseInt(st.nextToken());
            counseling[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int[] dp = new int[N + 2];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);

            if (i + counseling[i][0] > dp.length - 1) {
                continue;
            }
            dp[i + counseling[i][0]] = Math.max(dp[i + counseling[i][0]], max + counseling[i][1]);
        }

        bw.write(String.valueOf(dp[N + 1]));
        br.close();
        bw.close();
    }
}
