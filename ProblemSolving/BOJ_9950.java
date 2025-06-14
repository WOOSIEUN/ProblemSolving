import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a == 0) {
                a = c / b;
            } else if (b == 0) {
                b = c / a;
            } else if (c == 0) {
                c = a * b;
            }

            sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
