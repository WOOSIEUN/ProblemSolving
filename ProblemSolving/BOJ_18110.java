import java.io.*;
import java.util.Arrays;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);

        int sum = 0, margin = (int) Math.round(N * 0.15);;
        for (int i = margin; i < N - margin; i++) {
            sum += levels[i];
        }

        double avg = (double) sum / (N - (margin * 2));
        bw.write(String.valueOf(Math.round(avg)));
        br.close();
        bw.close();
    }
}
