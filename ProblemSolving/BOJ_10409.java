import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int numOfJob = 0, curTime = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int jobDuration = Integer.parseInt(st.nextToken());
            if (curTime + jobDuration > T) {
                break;
            }
            curTime += jobDuration;
            numOfJob++;
        }

        bw.write(String.valueOf(numOfJob));
        br.close();
        bw.close();
    }
}
