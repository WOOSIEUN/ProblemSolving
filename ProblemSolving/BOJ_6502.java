import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int t = 1; ; t++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                break;
            }

            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            sb.append("Pizza ").append(t).append(doesFitOnTheTable(r, w, l)? " fits on the table.\n" : " does not fit on the table.\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean doesFitOnTheTable(int r, int w, int l) {
        return Math.sqrt(w * w + l * l) <= 2 * r;
    }
}
