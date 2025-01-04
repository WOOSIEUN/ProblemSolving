import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] sides = new int[3];
            st = new StringTokenizer(br.readLine());
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(sides);

            sb.append("Scenario #").append(i+1).append(":").append("\n");
            sb.append(sides[2] * sides[2] == (sides[0] * sides[0] + sides[1] * sides[1]) ? "yes\n\n" : "no\n\n");
        }

        bw.write(sb.delete(sb.length() - 2, sb.length()).toString());
        br.close();
        bw.close();
    }
}
