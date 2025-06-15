import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sb.append(N / C + (N % C == 0 ? 0 : 1)).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
