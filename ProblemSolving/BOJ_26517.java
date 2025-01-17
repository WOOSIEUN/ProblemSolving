import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long left = (long) Integer.parseInt(st.nextToken()) * k + Integer.parseInt(st.nextToken());
        long right = (long) Integer.parseInt(st.nextToken()) * k + Integer.parseInt(st.nextToken());

        bw.write(left == right ? "Yes " + left : "No");
        br.close();
        bw.close();
    }
}
