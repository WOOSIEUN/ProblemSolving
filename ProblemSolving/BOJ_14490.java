import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num = GCD(N, M);
        bw.write(String.format("%d:%d", N / num, M / num));
        br.close();
        bw.close();
    }

    private static int GCD(int a, int b) {
        if (b % a == 0) {
            return a;
        }
        else return GCD(b % a, a);
    }
}
