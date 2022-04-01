import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	static class Node {
		int x, y, key, cnt;
		public Node(int x, int y, int key, int cnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}
	static Node minsik;
	static int N, M, nx, ny, next;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Node> q = new LinkedList<Node>();	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visited = new boolean [64][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				if(map[i][j] == '0') {
					map[i][j] = '.';
					minsik = new Node(i, j, 0, 0);
				}
		}
		sb.append(bfs());
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int bfs() {
		q.offer(minsik);
		visited[minsik.key][minsik.x][minsik.y] = true;		

		while(!q.isEmpty()) {
			Node cur = q.poll();
			for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny) && !visited[cur.key][nx][ny]) {
					next = map[nx][ny];
					if(next == '.') {
						visited[cur.key][nx][ny] = true;
						q.offer(new Node(nx, ny, cur.key, cur.cnt + 1));
					} else if(next == '#') {
						continue;
					} else if(next >= 'a' && next <= 'f') {
						int key = (1 << (next - 'a')) | cur.key;
						if(!visited[key][nx][ny]) {
							visited[cur.key][nx][ny] = true;
							visited[key][nx][ny] = true;
							q.offer(new Node(nx, ny, key, cur.cnt + 1));
						}
					} else if(next >= 'A' && next <= 'F') {
						int getKey = (1 << (next - 'A')) & cur.key;
						if(getKey > 0) {
							visited[cur.key][nx][ny] = true;
							q.offer(new Node(nx, ny, cur.key, cur.cnt + 1));
						}
					} else if(next == '1') {
						return cur.cnt + 1;
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M) ? true : false;
	}
}