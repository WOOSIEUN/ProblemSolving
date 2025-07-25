import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int ans = N;
            while (N / K > 0) {
                ans += (N / K);
                N = N / K + N % K;
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
