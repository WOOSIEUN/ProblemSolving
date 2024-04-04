import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6439 {
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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Point[] line = new Point [2];
			line[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			line[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Point[] rectangle = new Point [2];
			rectangle[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			rectangle[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if (rectangle[0].x > rectangle[1].x) {
				rectangle[1].x = swap(rectangle[0].x, rectangle[0].x = rectangle[1].x);
			}
			
			if (rectangle[0].y > rectangle[1].y) {
				rectangle[1].y = swap(rectangle[0].y, rectangle[0].y = rectangle[1].y);
			}
			
			if ((isInside(line[0], rectangle) && isInside(line[1], rectangle))
					|| isCross(line[0], line[1], rectangle[0], new Point(rectangle[0].x, rectangle[1].y))
					|| isCross(line[0], line[1], new Point(rectangle[0].x, rectangle[1].y), rectangle[1])
					|| isCross(line[0], line[1], rectangle[0], new Point(rectangle[1].x, rectangle[0].y))
					|| isCross(line[0], line[1], new Point(rectangle[1].x, rectangle[0].y), rectangle[1])) {
				sb.append("T\n");
			} else {
				sb.append("F\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static boolean isInside(Point point, Point[] rectangle) {
		return rectangle[0].x < point.x && point.x < rectangle[1].x && rectangle[0].y < point.y && point.y < rectangle[1].y;
	}

	private static boolean isCross(Point p1, Point p2, Point p3, Point p4) {
		int firstRes = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		int secondRes = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if (firstRes == 0 && secondRes == 0) {
			sortPoints(p1, p2, p3, p4);
			return isSmall(p1, p4) && isSmall(p3, p2);
		} else {
			return firstRes <= 0 && secondRes <= 0;
		}
	}
	
	private static void sortPoints(Point p1, Point p2, Point p3, Point p4) {
		if (isSmall(p2, p1)) {
			swap(p1, p2);
		}
		
		if (isSmall(p4, p3)) {
			swap(p3, p4);
		}
	}
	
	private static int swap(int a, int b) {
		return a;			
	}

	private static void swap(Point p1, Point p2) {
		int x = p1.x, y = p1.y;
		p1.x = p2.x;
		p1.y = p2.y;
		p2.x = x;
		p2.y = y;
	}
	
	public static boolean isSmall(Point src, Point target) {
		if (src.x == target.x) {
			return src.y <= target.y ? true : false;			
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