import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int cntA = 0, cntB = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            cntA += (A > B) ? 1 : 0;
            cntB += (A < B) ? 1 : 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cntA).append(" ").append(cntB);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
