import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, cnt, maxCore, minWire;
	static int[][] map, dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Node> cores;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<Node>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if(i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;						
						cores.add(new Node(i, j));
					}
				}
			}
			minWire = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minWire).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void dfs(int idx, int core, int wire) {
		if (idx == cores.size()) { 
			if(maxCore < core) {
				maxCore = core;
				minWire = wire;
			} else if(maxCore == core) {
				minWire = Math.min(wire, minWire);
			}
			return;
		}	
		
		Node cur = cores.get(idx);
		for (int[] dir : dirs) {
			int cnt = 0;
			int nx = cur.x;
			int ny = cur.y;
			while (true) {
				nx += dir[0];
				ny += dir[1];
				if (!isInMap(nx, ny)) break;
				if(map[nx][ny] == 1) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			
			int ix = cur.x;
			int iy = cur.y;
			for(int i = 0; i < cnt; i++) {
                ix += dir[0];
                iy += dir[1];
                map[ix][iy] = 1;
            }
			
			if(cnt == 0)
				dfs(idx + 1, core, wire);
            else {
            	dfs(idx + 1, core + 1, wire + cnt);
            	ix = cur.x;
    			iy = cur.y;
            	for(int i = 0; i < cnt; i++) {
            		ix += dir[0];
                	iy += dir[1];
                	map[ix][iy] = 0;
            	}
            }
		}
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N) ? true : false;
	}
}