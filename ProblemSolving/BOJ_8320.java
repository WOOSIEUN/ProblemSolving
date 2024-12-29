import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(numOfRectangles(N)));
        br.close();
        bw.close();
    }

    public static int numOfRectangles(int N) {
        int ans = 0;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            for (int j = i; i * j <= N; j++) {
                ans++;
            }
        }
        return ans;
    }
}
