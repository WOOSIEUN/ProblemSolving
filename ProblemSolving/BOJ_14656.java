import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i != Integer.parseInt(st.nextToken())) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
