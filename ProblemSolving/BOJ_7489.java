import java.io.*;

public class BOJ_7489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int num = 1;
            for (int i = 2; i <= n; i++) {
                num *= i;
                while (num % 10 == 0) {
                    num /= 10;
                }
                num %= 100000;
            }
            sb.append(num % 10).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
