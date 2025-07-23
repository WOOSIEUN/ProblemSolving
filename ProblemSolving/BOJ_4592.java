import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            int prev = Integer.parseInt(st.nextToken());
            sb.append(prev).append(" ");

            for (int i = 1; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == prev) {
                    continue;
                }
                sb.append(cur).append(" ");
                prev = cur;
            }
            sb.append("$\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
