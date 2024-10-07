import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0, result = 0;
        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= i; j++) {
                cnt++;
                if (A <= cnt && cnt <= B) {
                    result += i;
                }
            }
        }

        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
