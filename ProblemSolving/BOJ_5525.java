import java.io.*;

public class BOJ_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int[] lenOfIO = new int[M];
        int ans = 0;
        for (int i = 1; i < S.length - 1; i++) {
            if (S[i] == 'O' && S[i + 1] == 'I') {
                lenOfIO[i + 1] = lenOfIO[i - 1] + 1;

                if (lenOfIO[i + 1] >= N && S[i - 2 * N + 1] == 'I')
                    ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
