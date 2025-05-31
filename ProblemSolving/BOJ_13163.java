import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        final String prefix = "god";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(prefix);

            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
