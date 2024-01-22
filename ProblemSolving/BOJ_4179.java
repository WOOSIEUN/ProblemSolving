import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int R, C;
	static int[][] map, dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int [R][C];
		visited = new boolean [R][C];
		
		Node person = null;
		ArrayList<Node> fireList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (line[j] == '#') {
					map[i][j] = -1;
				} else if (line[j] == 'J') {
					person = new Node(i, j);
				} else if (line[j] == 'F') {
					map[i][j] = 1;
					fireList.add(new Node(i, j));
				}
			}
		}
		
		bw.write(escapeMaze(person, fireList));
		br.close();
		bw.close();
	}

	private static String escapeMaze(Node personStart, ArrayList<Node> fireStart) {
		Queue<Node> personQueue = new LinkedList<>();
		Queue<Node> fireQueue = new LinkedList<>();
		personQueue.add(personStart);
		for (int i = 0; i < fireStart.size(); i++) {
			fireQueue.add(fireStart.get(i));
		}
		
		for (int time = 1; !personQueue.isEmpty(); time++) {			
			int fireQueueLen = fireQueue.size();
			while (fireQueueLen-- > 0) {
				Node cur = fireQueue.poll();
				for (int[] dir : dirs) {
					int nx = cur.x + dir[0];
					int ny = cur.y + dir[1];
					
					if (!isInMap(nx, ny) || map[nx][ny] != 0) {
						continue;
					}
					
					map[nx][ny] = 1;
					fireQueue.add(new Node(nx, ny));
				}
			}
			
			int personQueueLen = personQueue.size();
			while (personQueueLen-- > 0) {
				Node cur = personQueue.poll();
								
				for (int[] dir : dirs) {
					int nx = cur.x + dir[0];
					int ny = cur.y + dir[1];
					
					if (!isInMap(nx, ny)) {
						return String.valueOf(time);
					}
					
					if (visited[nx][ny] || map[nx][ny] != 0) {
						continue;
					}
					
					visited[nx][ny] = true;
					personQueue.add(new Node(nx, ny));
				}
			}
		} 
		
		return "IMPOSSIBLE";
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}
