import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(br.readLine());
            int I = Integer.parseInt(br.readLine());

            int[] items = new int[I];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < I; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }

            int[] ans = findTwoItems(items, C);
            sb.append("Case #").append(t + 1).append(": ").append(ans[0]).append(" ").append(ans[1]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static int[] findTwoItems(int[] items, int credit) {
        int[] ans = new int[2];
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (i == j) {
                    continue;
                }

                if (items[i] + items[j] == credit) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                }
            }
        }
        return ans;
    }
}
