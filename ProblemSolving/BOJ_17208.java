import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][K + 1];

        for (int order = 1; order < N + 1; order++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int burger = M; burger > 0; burger--) {
                for (int fries = K; fries > 0; fries--) {
                    if (x <= burger && y <= fries){
                        dp[burger][fries] = Math.max(dp[burger][fries], dp[burger - x][fries - y] + 1);
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[M][K]));
        br.close();
        bw.close();
    }
}
