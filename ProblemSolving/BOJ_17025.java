import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17025 {
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int maxArea = 0, perimeterOfMaxArea = 0;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] iceCream, visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());		
		iceCream = new boolean [N][N];
		visited = new boolean [iceCream.length][iceCream.length];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				iceCream[i][j] = line.charAt(j) == '#' ? true : false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && iceCream[i][j]) {
					findPerimeterOfLargestArea(i, j);
				}
			}
		}
				
		bw.write(maxArea + " " + perimeterOfMaxArea);
		br.close();
		bw.close();
	}

	private static void findPerimeterOfLargestArea(int x, int y) {
		int area = 1, perimeter = 0;
		Queue<Node> iceCreamQueue = new LinkedList<>();
		iceCreamQueue.add(new Node(x, y));
		visited[x][y] = true;
		
		while (!iceCreamQueue.isEmpty()) {
			Node cur = iceCreamQueue.poll();
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				
				if (!isInMap(nx, ny) || !iceCream[nx][ny]) {
					perimeter++;
				} else if (isInMap(nx, ny) && !visited[nx][ny]) {
					iceCreamQueue.add(new Node(nx, ny));
					visited[nx][ny] = true;
					area++;
				}
			}
		}
		
		if (area > maxArea) {
			maxArea = area;
			perimeterOfMaxArea = perimeter;
		} else if (area == maxArea && perimeterOfMaxArea > perimeter) {
			perimeterOfMaxArea = perimeter;
		}
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < iceCream.length && 0 <= y && y < iceCream.length;
	}
}
