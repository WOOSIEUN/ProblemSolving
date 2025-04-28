import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] testSites = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            testSites[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long ans = N;
        for (int i = 0; i < N; i++) {
            if (testSites[i] <= B) {
                continue;
            }
            ans += (testSites[i] - B) / C + ((testSites[i] - B) % C == 0 ? 0 : 1);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
