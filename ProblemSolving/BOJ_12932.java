import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] melody = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < melody.length; i++) {
            melody[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = rec(0, 0, dp, melody);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static int rec(int a, int b, int[][] dp, int[] melody) {
        if (a == melody.length - 1 || b == melody.length - 1) {
            return 0;
        }

        if (dp[a][b] != -1) {
            return dp[a][b];
        }

        int p = Math.max(a, b) + 1;

        int costA = rec(p, b, dp, melody) + (a != 0 ? Math.abs(melody[a] - melody[p]) : 0);
        int costB = rec(a, p, dp, melody) + (b != 0 ? Math.abs(melody[b] - melody[p]) : 0);

        return dp[a][b] = Math.min(costA, costB);
    }
}
