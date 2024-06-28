import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Softeer_함께하는_효도 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int MAXTURN = 3;
    static int maxHarvestYield;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int [n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Point[] friends = new Point [m];
        int harvestYield = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            friends[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            harvestYield += map[friends[i].x][friends[i].y];
            map[friends[i].x][friends[i].y] = 0;
        }

        dfs(friends[0].x, friends[0].y, 0, harvestYield, 0, friends, map);
        bw.write(String.valueOf(maxHarvestYield));
        br.close();
        bw.close();
	}

    private static void dfs(int x, int y, int turn, int harvestYield, int friendIdx, Point[] friends, int[][] map) {
        if (turn == MAXTURN) {
            if (friendIdx < friends.length - 1) {                
                dfs(friends[friendIdx + 1].x, friends[friendIdx + 1].y, 0, harvestYield, friendIdx + 1, friends, map);
            } else {
                maxHarvestYield = Math.max(harvestYield, maxHarvestYield);
            }
            return;
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (!isInMap(nx, ny, map.length)) {
                continue;
            }

            int value = map[nx][ny];
            map[nx][ny] = 0;
            dfs(nx, ny, turn + 1, harvestYield + value, friendIdx, friends, map);
            map[nx][ny] = value;
        }
    }

    private static boolean isInMap(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
