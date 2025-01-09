import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int workHour = Integer.parseInt(st.nextToken());
            int workMinute = Integer.parseInt(st.nextToken());
            int workSecond = Integer.parseInt(st.nextToken());

            int homeHour = Integer.parseInt(st.nextToken());
            int homeMinute = Integer.parseInt(st.nextToken());
            int homeSecond = Integer.parseInt(st.nextToken());

            int ansSecond = homeSecond - workSecond;
            int ansMinute = homeMinute - workMinute;
            int ansHour = homeHour - workHour;

            if (ansSecond < 0) {
                ansSecond += 60;
                ansMinute--;
            }

            if (ansMinute < 0) {
                ansMinute += 60;
                ansHour--;
            }

            sb.append(ansHour).append(" ").append(ansMinute).append(" ").append(ansSecond).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
