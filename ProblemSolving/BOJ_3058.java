import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int ans = 0, min = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) {
                    continue;
                }
                ans += num;
                min = Math.min(min, num);
            }
            sb.append(ans).append(" ").append(min).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
