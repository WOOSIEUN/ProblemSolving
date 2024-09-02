import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] DP = new int [N + 1];
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }

        int M = Integer.parseInt(br.readLine());
        int[] vip = new int [M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int ways = 1, prev = 0;
        for (int i = 0; i < M; i++) {
            ways *= (DP[vip[i] - prev - 1]);
            prev = vip[i];
        }
        ways *= (DP[N - prev]);

        bw.write(String.valueOf(ways));
        br.close();
        bw.close();
    }
}
