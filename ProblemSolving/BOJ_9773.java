import java.io.*;

public class BOJ_9773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int val1 = 0, val2 = 0;
            char[] IDs = br.readLine().toCharArray();
            for (int i = 0; i < IDs.length; i++) {
                val1 += IDs[i] - '0';
                if (i > IDs.length - 4) {
                    val2 += IDs[i] - '0';
                    val2 *= 10;
                }
            }

            int ans = val1 + val2;
            if (ans >= 10000) {
                ans %= 10000;
            } else if (ans < 1000) {
                ans += 1000;
            }
            sb.append(String.format("%04d", ans)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
