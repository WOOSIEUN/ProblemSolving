import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i < dp.length; i++){
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(String.valueOf(dp[N]));
        br.close();
        bw.close();
    }
}
