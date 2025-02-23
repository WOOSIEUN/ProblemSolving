import java.io.*;

public class BOJ_15372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long num = Long.parseLong(br.readLine());
            sb.append(num * num).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
