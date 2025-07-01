import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (true) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0) {
                break;
            }
            sb.append(target).append(" is ").append(target % N == 0 ? "" : "NOT ").append("a multiple of ").append(N).append(".\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
