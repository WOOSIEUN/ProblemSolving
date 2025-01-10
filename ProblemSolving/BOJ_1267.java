import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int youngsik = 0, minsik = 0;
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            youngsik += ((time / 30) + 1) * 10;
            minsik += ((time / 60) + 1) * 15;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(youngsik == minsik ? "Y M " : (youngsik > minsik ? "M " : "Y ")).append(Math.min(youngsik, minsik));

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
