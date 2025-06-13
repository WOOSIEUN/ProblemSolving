import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("$").append(String.format("%.2f\n", Double.parseDouble(br.readLine()) * 0.8));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
