import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] name = br.readLine().toCharArray();
        int[] alpabets = new int[26];
        for (char ch : name) {
            alpabets[ch - 'A']++;
        }

        boolean valid = true;
        int mid = -1;
        for (int i = 0; i < alpabets.length; i++) {
            if (alpabets[i] % 2 == 0) {
                continue;
            }

            if (mid != -1) {
                valid = false;
                break;
            } else {
                mid = i;
            }
        }

        String ans = "I'm Sorry Hansoo";
        if (valid) {
            StringBuilder left = new StringBuilder();
            for (int cur = 0; cur < alpabets.length; cur++) {
                for (int i = 0; i < alpabets[cur] / 2; i++) {
                    left.append((char) (cur + 'A'));
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(left);

            if (mid != -1) {
                sb.append((char) (mid + 'A'));
            }

            ans = sb.append(left.reverse()).toString();
        }

        bw.write(ans);
        br.close();
        bw.close();
    }
}
