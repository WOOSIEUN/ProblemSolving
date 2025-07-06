import java.io.*;

public class BOJ_2028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String square = String.valueOf(N * N);
            sb.append(square.endsWith(String.valueOf(N)) ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
