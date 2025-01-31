import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            HashSet<Integer> cds = new HashSet<>();
            for (int i = 0; i < N; i++) {
                cds.add(Integer.parseInt(br.readLine()));
            }

            int ans = 0;
            for (int i = 0; i < M; i++) {
                if (cds.contains(Integer.parseInt(br.readLine()))) {
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
