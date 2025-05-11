import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            if (T == Integer.parseInt(st.nextToken())) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
