import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 5, dot = 7;
        for (int i = 1; i < N; i++) {
            sum = (sum + dot) % 45678;
            dot += 3;
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}
