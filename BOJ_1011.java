import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int max = (int) Math.sqrt(dist);

            if (max == Math.sqrt(dist)) {
                sb.append(max * 2 - 1);
            } else if (dist <= max * max + max) {
                sb.append(max * 2);
            } else {
                sb.append(max * 2 + 1);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
