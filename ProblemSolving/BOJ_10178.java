import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append("You get ").append(c / v).append(" piece(s) and your dad gets ").append(c % v).append(" piece(s).\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
