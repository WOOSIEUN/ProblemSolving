import java.io.*;

public class BOJ_17358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MOD = 1_000_000_007;
        int N = Integer.parseInt(br.readLine());
        long ans = 1;

        for (int i = N - 1; i > 0; i -= 2) {
            ans = (ans * i) % MOD;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
