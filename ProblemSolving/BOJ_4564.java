import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            sb.append(N).append(" ");
            while (N > 9) {
                int result = 1;
                char[] nums = String.valueOf(N).toCharArray();
                for (char num : nums) {
                    result *= num - '0';
                }
                sb.append(result).append(" ");
                N = result;
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
