import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX = 5001;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = MAX;
                if (i == j) {
                    distance[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            distance[from][to] = 1;
            distance[to][from] = 1;
        }

        for (int stopover = 0; stopover < N; stopover++) {
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    if (distance[from][to] > distance[from][stopover] + distance[stopover][to]) {
                        distance[from][to] = distance[from][stopover] + distance[stopover][to];
                    }
                }
            }
        }

        int maxIdx = -1, maxDist = MAX;
        for (int idx = 0; idx < N; idx++) {
            int kevinBacon = 0;
            for (int j = 0; j < N; j++) {
                kevinBacon += distance[idx][j];
            }

            if (kevinBacon < maxDist) {
                maxDist = kevinBacon;
                maxIdx = idx;
            }
        }

        bw.write(String.valueOf(maxIdx + 1));
        br.close();
        bw.close();
    }
}
