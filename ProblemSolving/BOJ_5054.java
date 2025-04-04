import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int min = 101, max = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            sb.append((max - min) * 2).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
