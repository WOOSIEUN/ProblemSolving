import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int maxScore = -1, maxIdx = -1;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());

            int score = 0;
            for (int j = 0; j < 4; j++) {
                score += Integer.parseInt(st.nextToken());
            }

            if (score > maxScore) {
                maxScore = score;
                maxIdx = i;
            }
        }

        bw.write(String.format("%d %d", maxIdx, maxScore));
        br.close();
        bw.close();
    }
}
