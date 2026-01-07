import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] remains = new int[M];
        long prefixSum = 0;
        for(int i = 0; i < N; i++) {
            prefixSum += Integer.parseInt(st.nextToken());
            remains[(int) (prefixSum % M)]++;
        }

        long ans = remains[0];
        for (int i = 0; i < M; i++) {
            ans += (long) remains[i] * (remains[i] - 1) / 2;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
