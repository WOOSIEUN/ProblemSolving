import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double dollar = 100;
        int N = Integer.parseInt(br.readLine());
        int[] exchangeRates = new int[N];

        for (int i = 0; i < N; i++) {
            exchangeRates[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            if (exchangeRates[i] > exchangeRates[i + 1]) {
                dollar *= (double) exchangeRates[i] / exchangeRates[i + 1];
            }
        }

        bw.write(String.format("%.2f", dollar));
        br.close();
        bw.close();
    }
}
