import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(getMaxSizeOfSnowBall(0, 0, 1, M, map)));
        br.close();
        bw.close();
    }

    private static int getMaxSizeOfSnowBall(int cur, int time, int size, int MAX, int[] map) {
        if (time > MAX) {
            return 0;
        } else if (time == MAX) {
            return size;
        }
        return Math.max(getMaxSizeOfSnowBall(cur + 1, time + 1, size + (cur + 1 < map.length ? map[cur + 1] : 0), MAX, map)
                    , getMaxSizeOfSnowBall(cur + 2, time + 1, size / 2 + (cur + 2 < map.length ? map[cur + 2] : 0), MAX, map));
    }
}
