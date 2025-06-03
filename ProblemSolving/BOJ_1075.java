import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N -= (N % 100);
        while (N % F != 0) {
            N++;
        }

        bw.write(String.format("%02d", N % 100));
        br.close();
        bw.close();
    }
}
