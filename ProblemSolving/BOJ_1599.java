import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1599 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this ==obj) {
				return true;
			}
			
			if (obj instanceof Point) {
				Point point = (Point) obj;
				
				if (this.x == point.x && this.y == point.y) {
					return true;
				}
			}
			
			return false;
		}
		
		@Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
	}
	
	static int N;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static HashSet<Point> apples;
	static HashMap<Integer, Character> turnCmd;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		apples = new HashSet<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			apples.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
		}		

		int L = Integer.parseInt(br.readLine());
		turnCmd = new HashMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			turnCmd.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}		
		
		bw.write(String.valueOf(playDummy()));
		br.close();
		bw.close();
	}

	private static int playDummy() {
		Point head = new Point(0, 0);
		Queue<Point> snake = new LinkedList<>();
		snake.add(new Point(0, 0));
		int headDir = 1, time = 0;
				
		while (true) {
			int nx = head.x + dirs[headDir][0];
			int ny = head.y + dirs[headDir][1];
			head = new Point(nx, ny);
			time++;
			
			if (!isInMap(nx, ny) || snake.contains(head)) {
				break;
			}

			snake.add(head);
			
			if (apples.contains(head)) {
				apples.remove(head);
			} else {
				snake.poll();
			}
            
			if (turnCmd.containsKey(time)) {
				if (turnCmd.get(time) == 'D') {
					headDir = (headDir + 1) % 4;
				} else {
					headDir = (headDir - 1) < 0 ? 3 : headDir - 1;
				}
			}			
		}
		
		return time;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
