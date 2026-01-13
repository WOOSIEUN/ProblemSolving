import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            if (N == Integer.parseInt(st.nextToken())) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
