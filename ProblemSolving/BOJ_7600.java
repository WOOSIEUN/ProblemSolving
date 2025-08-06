import java.io.*;

public class BOJ_7600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("#")) {
            char[] chars = input.toLowerCase().toCharArray();
            boolean[] alpabets = new boolean[26];
            for (char c : chars) {
                if (c < 'a' || c > 'z') {
                    continue;
                }
                alpabets[c - 'a'] = true;
            }

            int ans = 0;
            for (int i = 0; i < alpabets.length; i++) {
                ans += (alpabets[i] ? 1 : 0);
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
