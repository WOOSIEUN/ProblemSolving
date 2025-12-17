import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736 {
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startX = -1, startY = -1;
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        int ans = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (!isInMap(nx, ny, N, M) || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                if (map[nx][ny] == 'P') {
                    ans++;
                }
                queue.add(new Node(nx, ny));
            }
        }

        bw.write(ans == 0 ? "TT" : String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean isInMap(int x, int y, int X, int Y) {
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}
