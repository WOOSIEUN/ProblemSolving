import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int numOfKids = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numOfKids += Integer.parseInt(st.nextToken()) / K;
            }
            sb.append(numOfKids).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
