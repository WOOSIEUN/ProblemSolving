import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        int[][] dist = new int[N][M];
        int startX = -1, startY = -1;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                char input = st.nextToken().charAt(0);
                if (input == '0') {
                    dist[i][j] = 0;
                    continue;
                }

                if (input == '2') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = true;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (!isInMap(nx, ny, N, M) || !map[nx][ny] || dist[nx][ny] != -1) {
                    continue;
                }
                
                queue.add(new Node(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean isInMap(int nx, int ny, int N, int M) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}
