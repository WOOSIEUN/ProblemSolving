import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= K; i++) {
            ans = Math.max(ans, reverseInt(N * i));
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static int reverseInt(int num) {
        char[] target = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = target.length - 1; i >= 0; i--) {
            sb.append(target[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
