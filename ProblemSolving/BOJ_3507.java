import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ans = 0, LIMIT = 100;
        for (int i = 0; i < N && i < LIMIT; i++) {
            ans += (N - i < LIMIT ? 1 : 0);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
