import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < B.length - A.length + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] != B[i + j]) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
