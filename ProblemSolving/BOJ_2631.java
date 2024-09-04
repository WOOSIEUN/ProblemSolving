import java.io.*;

public class BOJ_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] children = new int [N];
        int[] LIS = new int [N];

        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        for (int cur = 0; cur < N; cur++) {
            LIS[cur] = 1;

            for (int prev = 0; prev < cur; prev++) {
                if (children[prev] < children[cur] && LIS[prev] + 1 > LIS[cur]) {
                    LIS[cur] = LIS[prev] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, LIS[i]);
        }

        bw.write(String.valueOf(N - ans));
        br.close();
        bw.close();
    }
}
