import java.io.*;

public class BOJ_2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Integer.parseInt(br.readLine()) - 1;
        }

        bw.write(String.valueOf(ans + 1));
        br.close();
        bw.close();
    }
}
