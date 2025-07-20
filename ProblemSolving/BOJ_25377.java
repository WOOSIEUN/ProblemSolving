import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B) {
                continue;
            }

            min = Math.min(min, B);
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        bw.write(String.valueOf(min));
        br.close();
        bw.close();
    }
}
