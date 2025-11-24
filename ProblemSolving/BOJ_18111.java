import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = Integer.MAX_VALUE, height = Integer.MAX_VALUE;
        for (int curHeight = 0; curHeight <= 256; curHeight++) {
            int removed = 0;
            int packed = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > curHeight) {
                        removed += map[i][j] - curHeight;
                    } else if (map[i][j] < curHeight) {
                        packed += curHeight - map[i][j];
                    }
                }
            }

            if (removed + B >= packed) {
                int curTime = removed * 2 + packed;
                if (curTime <= time) {
                    time = curTime;
                    height = curHeight;
                }
            }
        }

        bw.write(String.format("%d %d", time, height));
        br.close();
        bw.close();
    }
}
