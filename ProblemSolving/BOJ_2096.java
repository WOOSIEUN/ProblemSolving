import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int width = 3;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][width];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minDP = new int[N][width];
        int[][] maxDP = new int[N][width];

        for (int i = 0; i < map[0].length; i++) {
            minDP[0][i] = map[0][i];
            maxDP[0][i] = map[0][i];
        }

        for (int col = 1; col < map.length; col++) {
            for (int row = 0; row < map[col].length; row++) {
                minDP[col][row] = minDP[col - 1][row];
                maxDP[col][row] = maxDP[col - 1][row];

                if (row != 0) {
                    minDP[col][row] = Math.min(minDP[col][row], minDP[col - 1][row - 1]);
                    maxDP[col][row] = Math.max(maxDP[col][row], maxDP[col - 1][row - 1]);
                }

                if (row != map[col].length - 1) {
                    minDP[col][row] = Math.min(minDP[col][row], minDP[col - 1][row + 1]);
                    maxDP[col][row] = Math.max(maxDP[col][row], maxDP[col - 1][row + 1]);
                }

                minDP[col][row] += map[col][row];
                maxDP[col][row] += map[col][row];
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < map[map.length - 1].length; i++) {
            min = Math.min(min, minDP[map.length - 1][i]);
            max = Math.max(max, maxDP[map.length - 1][i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append(" ").append(min);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
