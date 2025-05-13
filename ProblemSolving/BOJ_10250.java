import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int room = N / H + 1;
            if (floor == 0) {
                floor = H;
                room--;
            }

            sb.append(floor * 100 + room).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
