import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = new StringBuilder(st.nextToken()).reverse().toString();
        String B = new StringBuilder(st.nextToken()).reverse().toString();

        StringBuilder sb = new StringBuilder();
        String ans = sb.append(Integer.parseInt(A) + Integer.parseInt(B)).reverse().toString();
        bw.write(String.valueOf(Integer.parseInt(ans)));
        br.close();
        bw.close();
    }
}
