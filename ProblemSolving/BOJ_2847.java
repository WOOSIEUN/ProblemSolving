import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = scores.length - 1; i > 0; i--) {
            if (scores[i] <= scores[i - 1]) {
                ans += (scores[i - 1] - scores[i] + 1);
                scores[i - 1] = scores[i] - 1;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
