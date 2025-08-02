import java.io.*;

public class BOJ_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            for (int i = 0; num > 0; i++, num /= 2) {
                if (num % 2 == 1) {
                    sb.append(i).append(" ");
                };
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
