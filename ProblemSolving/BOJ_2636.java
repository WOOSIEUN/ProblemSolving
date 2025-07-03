import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    static class Point {
        int x, y;
        public Point(int x, int y) {
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
        boolean[][] cheese = new boolean[N][M];

        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = (Integer.parseInt(st.nextToken()) == 1);
                if (cheese[i][j]) {
                    cheeseCount++;
                }
            }
        }

        int time = 0, leftCheese1HourAgo = 0;
        while (cheeseCount > 0) {
            leftCheese1HourAgo = cheeseCount;
            cheeseCount = melts(cheese, cheeseCount);
            time++;
        }

        bw.write(String.format("%d\n%d", time, leftCheese1HourAgo));
        br.close();
        bw.close();
    }

    private static int melts(boolean[][] cheese, int cheeseCount) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[cheese.length][cheese[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (!isInMap(nx, ny, cheese.length, cheese[0].length) || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                if (cheese[nx][ny]) {
                    cheese[nx][ny] = false;
                    cheeseCount--;
                    continue;
                }
                queue.add(new Point(nx, ny));
            }
        }
        return cheeseCount;
    }

    private static boolean isInMap(int nx, int ny, int X, int Y) {
        return 0 <= nx && nx < X && 0 <= ny && ny < Y;
    }
}
