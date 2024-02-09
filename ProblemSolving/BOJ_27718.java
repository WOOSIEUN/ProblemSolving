import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_27718 {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		Point[][] lines = new Point [N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i][0]= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			lines[i][1]= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[][] relations = new int [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i == j) {
					relations[i][j] = 3;
					continue;
				}
				
				int relation = getRelation(lines[i][0], lines[i][1], lines[j][0], lines[j][1]);
				relations[i][j] = relation;
				relations[j][i] = relation;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(relations[i][j]);
			}
			sb.append("\n");
		}
				
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int getRelation(Point p1, Point p2, Point p3, Point p4) {
		int ccw123 = ccw(p1, p2, p3), ccw124 = ccw(p1, p2, p4), ccw341 = ccw(p3, p4, p1), ccw342 = ccw(p3, p4, p2);
		
		int relation = -1;
		
		if (ccw123 * ccw124 < 0 && ccw341 * ccw342 < 0) {
			relation = 2;
		} else if (ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0) {
			if (ccw123 == 0 && ccw124 == 0 && ccw341 == 0 && ccw342 == 0) {
				sortPoints(p1, p2, p3, p4);			
				
				if (isSame(p1, p4) || isSame(p2, p3)) {
					relation = 1;
				} else if (isSmall(p1, p4) && isSmall(p3, p2)) {
					relation = 3;
				} else {
					relation = 0;
				}			
			} else {
				relation = 1;
			}
		} else {
			relation = 0;
		}
		
		return relation;
	}

	private static void sortPoints(Point p1, Point p2, Point p3, Point p4) {
		if (isSmall(p2, p1)) {
			swap(p1, p2);
		}
		
		if (isSmall(p4, p3)) {
			swap(p3, p4);
		}
	}

	private static void swap(Point p1, Point p2) {
		int x = p1.x, y = p1.y;
		p1.x = p2.x;
		p1.y = p2.y;
		p2.x = x;
		p2.y = y;
	}
	
	public static boolean isSame(Point src, Point target) {
		return src.x == target.x && src.y == target.y ? true : false;
	}

	public static boolean isSmall(Point src, Point target) {
		if (src.x == target.x) {
			return src.y < target.y ? true : false;			
		}
		return src.x < target.x ? true : false;
	}
	
	public static int ccw(Point p1, Point p2, Point p3) {
		long res = (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p3.x - p1.x) * (p2.y - p1.y);
		if (res < 0) {
			return -1;
		} else if (res > 0) {
			return 1;
		} else {
			return 0;
		} 
	}
}