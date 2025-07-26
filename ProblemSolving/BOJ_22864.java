import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int fatigue = 0, work = 0;
        for (int i = 0; i < 24; i++) {
            if (fatigue + A > M) {
                fatigue = Math.max(fatigue - C, 0);
                continue;
            }
            fatigue += A;
            work += B;
        }

        bw.write(String.valueOf(work));
        br.close();
        bw.close();
    }
}
