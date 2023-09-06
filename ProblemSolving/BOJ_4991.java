import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4991 {
	static class Node {
		int x, y, cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int W, H, minMove;
	static int[][] dist, dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[] selected;
	static ArrayList<Node> dirt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}
			
			minMove = Integer.MAX_VALUE;
			map = new char [H][W];
			dirt = new ArrayList<>();
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '*') {
						dirt.add(new Node(i, j, 0));
					} else if (map[i][j] == 'o') {
						dirt.add(0, new Node(i, j, 0));
					}
				}
			}
			
			dist = new int [dirt.size()][dirt.size()];
			for (int i = 0; i < dirt.size(); i++) {
				if (!getMinDist(dirt.get(i), i)) {
					minMove = -1;
					break;
				}
			}
			
			if (minMove == -1) {
				sb.append(minMove).append("\n");
				continue;
			} else {
				selected = new boolean [dirt.size()];
				getMinMove(0, 0, 0);
				sb.append(minMove).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void getMinMove(int startIdx, int cnt, int move) {
		if (cnt == dirt.size() - 1) {
			minMove = Math.min(minMove, move);
			return;
		}
		
		for (int destIdx = 1; destIdx < dirt.size(); destIdx++) {
			if (selected[destIdx]) {
				continue;
			}
			selected[destIdx] = true;
			getMinMove(destIdx, cnt + 1, move + dist[startIdx][destIdx]);
			selected[destIdx] = false;
		}
	}

	private static boolean getMinDist(Node start, int startIdx) {
		int cntDest = 0;
		boolean[][] visited = new boolean [H][W];
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				
				if (!isInMap(nx, ny) || visited[nx][ny] || map[nx][ny] == 'x') {
					continue;
				}				

				visited[nx][ny] = true;
				queue.offer(new Node(nx, ny, cur.cnt + 1));
				
				if ((map[nx][ny] == '*' || map[nx][ny] == 'o')) {
					for (int destIdx = 0; destIdx < dirt.size(); destIdx++) {
						Node dest = dirt.get(destIdx);
						if (dest.x == nx && dest.y == ny) {
							dist[startIdx][destIdx] = cur.cnt + 1;
							dist[destIdx][startIdx] = cur.cnt + 1;
							cntDest++;
						}
					}
				}
			}
		}
		return cntDest == dirt.size() - 1 ? true : false;
	}

	private static boolean isInMap(int nx, int ny) {
		return 0 <= nx && nx < H && 0 <= ny && ny < W;
	}
}
