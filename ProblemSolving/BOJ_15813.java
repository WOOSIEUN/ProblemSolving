import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] name = br.readLine().toCharArray();

        int ans = 0;
        for (char c : name) {
            ans += c - 'A' + 1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
