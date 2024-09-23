import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfStudent = 5, sum = 0;
        for (int i = 0; i < numOfStudent; i++) {
            int score = Integer.parseInt(br.readLine());
            sum += (score < 40 ? 40 : score);
        }

        bw.write(String.valueOf(sum / numOfStudent));
        br.close();
        bw.close();
    }
}
