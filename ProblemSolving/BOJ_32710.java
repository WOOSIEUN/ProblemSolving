import java.io.*;
import java.util.StringTokenizer;

public class BOJ_32710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i < 10; i++) {
            if (N % i == 0 && N / i < 10) {
                ans = 1;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
