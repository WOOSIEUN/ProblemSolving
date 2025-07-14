import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] konpeito = new int[3];
        int max = 0;
        for (int i = 0; i < konpeito.length; i++) {
            konpeito[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, konpeito[i]);
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += (max - konpeito[i]);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
