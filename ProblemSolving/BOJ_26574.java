import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26574 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(num).append(" ").append(num).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}