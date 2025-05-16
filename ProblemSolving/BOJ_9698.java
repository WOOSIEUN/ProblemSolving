import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());

            if (minute < 45) {
                minute += 15;
                hour--;
                if (hour < 0) {
                    hour = 23;
                }
            } else {
                minute -= 45;
            }
            sb.append("Case #").append(t).append(": ").append(hour).append(" ").append(minute).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
