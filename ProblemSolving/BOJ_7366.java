import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("sheep")) {
                    ans++;
                }
            }
            sb.append("Case ").append(i + 1).append(": This list contains ").append(ans).append(" sheep.\n\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
