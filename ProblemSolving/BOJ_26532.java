import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int ans = width * height / 4840 / 5;
        ans += (width * height % (4840 * 5) == 0 ? 0 : 1);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
