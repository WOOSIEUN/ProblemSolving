import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            boolean[] alpabet = new boolean[26];
            char[] input = br.readLine().toCharArray();

            for (char c : input) {
                alpabet[c - 'A'] = true;
            }

            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (!alpabet[i]) {
                    sum += i + 'A';
                }
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
