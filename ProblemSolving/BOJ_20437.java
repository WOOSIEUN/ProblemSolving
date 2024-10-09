import java.io.*;

public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] target = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append("1 1\n");
                continue;
            }

            int[] alphabet = new int[26];
            for (char c : target) {
                alphabet[c - 'a']++;
            }

            int min = Integer.MAX_VALUE, max = -1;
            for (int left = 0; left < target.length; left++) {
                if (alphabet[target[left] - 'a'] < k) {
                    continue;
                }

                int cnt = 1;
                for (int right = left + 1; right < target.length; right++) {
                    if (target[left] == target[right]) {
                        cnt++;
                    }

                    if (cnt == k) {
                        int len = right - left + 1;
                        min = Math.min(min, len);
                        max = Math.max(max, len);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE && max == -1) {
                sb.append("-1\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
