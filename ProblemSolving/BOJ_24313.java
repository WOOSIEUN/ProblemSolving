import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int ans = 0;
        if (a1 * n0 + a0 <= c * n0 && a1 <= c) {
            ans = 1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
