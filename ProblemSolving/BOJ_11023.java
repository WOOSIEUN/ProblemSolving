import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        while (st.hasMoreTokens()) {
            ans += Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
