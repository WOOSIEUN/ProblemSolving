import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append((c * e - b * f) / (a * e - b * d)).append(" ").append((c * d - a * f) / (b * d - a * e));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
