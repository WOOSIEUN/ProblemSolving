import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            boolean[] contained = new boolean[49];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    contained[Integer.parseInt(st.nextToken()) - 1] = true;
                }
            }
            sb.append(containsEveryNumber(contained) ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean containsEveryNumber(boolean[] contained) {
        for (int i = 0; i < contained.length; i++) {
            if (!contained[i]) {
                return false;
            }
        }
        return true;
    }
}
