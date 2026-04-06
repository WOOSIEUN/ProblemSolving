import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int last = A % 10;

        int[][] patterns = {
                {0}, {1}, {2,4,8,6}, {3,9,7,1},
                {4,6}, {5}, {6}, {7,9,3,1},
                {8,4,2,6}, {9,1}
        };

        int[] cycle = patterns[last];
        int idx = (B - 1) % cycle.length;

        bw.write(String.valueOf(cycle[idx]));
        br.close();
        bw.close();
    }
}
