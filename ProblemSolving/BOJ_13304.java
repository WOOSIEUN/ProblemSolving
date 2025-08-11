import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (Y == 1 || Y == 2) {
                students[0]++;
            } else if (Y == 3 || Y == 4) {
                if (S == 0) {
                    students[1]++;
                } else {
                    students[2]++;
                }
            } else {
                if (S == 0) {
                    students[3]++;
                } else {
                    students[4]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < students.length; i++) {
            ans += (students[i] / K + (students[i] % K == 0 ? 0 : 1));
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
