import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            sb.append(Character.toUpperCase(line.charAt(0))).append(line.substring(1)).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
