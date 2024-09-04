import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] continuousLIS = new int [N + 1];

        int maxLISLen = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int childNum = Integer.parseInt(st.nextToken());
            continuousLIS[childNum] = continuousLIS[childNum - 1] + 1;
            maxLISLen = Math.max(maxLISLen, continuousLIS[childNum]);
        }

        bw.write(String.valueOf(N - maxLISLen));
        br.close();
        bw.close();
    }
}
