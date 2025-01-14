import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i * i <= N; i++) {
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}