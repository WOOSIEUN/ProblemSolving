import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= C; i++) {
            ans += (K * i + P * i * i);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
