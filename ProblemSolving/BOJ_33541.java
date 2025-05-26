import java.io.*;
import java.util.StringTokenizer;

public class BOJ_33541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int ans = -1;
        for (int i = X + 1; i < 10000; ++i) {
            int num = i / 100 + i % 100;
            if (num * num == i) {
                ans = i;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
