import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int yonsei = 0, korea = 0;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                yonsei += Integer.parseInt(st.nextToken());
                korea += Integer.parseInt(st.nextToken());
            }

            if (yonsei > korea) {
                sb.append("Yonsei\n");
            } else if (yonsei < korea) {
                sb.append("Korea\n");
            } else {
                sb.append("Draw\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
