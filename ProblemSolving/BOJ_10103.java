import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int changyoung = 100, sangduck = 100;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int scoreOfChangYoung = Integer.parseInt(st.nextToken());
            int scoreOfSangDuck = Integer.parseInt(st.nextToken());
            if (scoreOfChangYoung < scoreOfSangDuck) {
                changyoung -= scoreOfSangDuck;
            } else if (scoreOfChangYoung > scoreOfSangDuck) {
                sangduck -= scoreOfChangYoung;
            }
        }

        bw.write(String.format("%d\n%d", changyoung, sangduck));
        br.close();
        bw.close();
    }
}
