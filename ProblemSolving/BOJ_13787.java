import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13787 {
	static class Robot {
		int x, y, dir;
		
		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
		public void setRobot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int H, W;
	static long L;
	static Robot robot;
	static boolean[][] map;
	static long[][][] visited;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static HashMap<Character, Integer> charToInt = new HashMap<>();
	static HashMap<Integer, Character> intToChar = new HashMap<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		initMap();
		
		while (true) {
			st = new StringTokenizer(br.readLine());			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			L = Long.parseLong(st.nextToken());
			
			if (H == 0 && W == 0 && L == 0) {
				break;
			}
			
			map = new boolean [H][W];
			for (int i = 0; i < H; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (line[j] != '.' && line[j] != '#') {
						robot = new Robot(i, j, charToInt.get(line[j]));
					}
					map[i][j] = (line[j] == '#' ? false : true);
				}
			}
			
			searchMap();
			sb.append(robot.x + 1).append(" ").append(robot.y + 1).append(" ").append(intToChar.get(robot.dir)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}


	private static void searchMap() {
		long depth = 0;
		initVisited();
		visited[robot.x][robot.y][robot.dir] = depth;
		
		while (true) {			
			turnRobot();
			moveRobot();			
			depth++;
			
			if (visited[robot.x][robot.y][robot.dir] != -1) {
				break;
			}

			visited[robot.x][robot.y][robot.dir] = depth;
			
			if (depth == L) {
				break;
			}
		}
		
		if (depth != L) {
			int left = (int) ((L - visited[robot.x][robot.y][robot.dir]) % (depth - visited[robot.x][robot.y][robot.dir]));
			
			for (int i = 0; i < left; i++) {
				turnRobot();
				moveRobot();
			}
		}
	}


	private static void initVisited() {
		visited = new long [H][W][4];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
	}


	private static void moveRobot() {
		int nx = robot.x + dirs[robot.dir][0];
		int ny = robot.y + dirs[robot.dir][1];
		robot.setRobot(nx, ny, robot.dir);		
	}


	private static void turnRobot() {
		int dir = robot.dir;
		int nx = robot.x + dirs[dir][0];
		int ny = robot.y + dirs[dir][1];
		while (!isInMap(nx, ny) || !map[nx][ny]) {
			dir = (dir + 1) % 4;
			nx = robot.x + dirs[dir][0];
			ny = robot.y + dirs[dir][1];
		}
		robot.setRobot(robot.x, robot.y, dir);
	}


	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}


	private static void initMap() {
		charToInt.put('N', 0);
		charToInt.put('E', 1);
		charToInt.put('S', 2);
		charToInt.put('W', 3);		
		intToChar.put(0, 'N');
		intToChar.put(1, 'E');
		intToChar.put(2, 'S');
		intToChar.put(3, 'W');		
	}	
	
}
