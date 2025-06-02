import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D1 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());

        double height = Math.pow(K, 2) - Math.pow((double) (D1 - D2) / 2, 2);

        bw.write(String.valueOf(height));
        br.close();
        bw.close();
    }
}
