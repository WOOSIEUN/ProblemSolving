import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r == e - c) {
                sb.append("does not matter\n");
            } else if (r > e - c) {
                sb.append("do not advertise\n");
            } else {
                sb.append("advertise\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
