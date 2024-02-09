import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20149 {
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
		
		Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int ccw123 = ccw(p1, p2, p3), ccw124 = ccw(p1, p2, p4), ccw341 = ccw(p3, p4, p1), ccw342 = ccw(p3, p4, p2);
		
		if ((ccw123 * ccw124 <= 0 && ccw341 * ccw342 < 0) ||  (ccw123 * ccw124 < 0 && ccw341 * ccw342 <= 0)) {
			sb.append(1).append("\n");
			
			double[] intersection = getIntersectionNotEndOfLine(p1, p2, p3, p4);
			sb.append(intersection[0]).append(" ").append(intersection[1]);			
		} else if (ccw123 * ccw124 == 0 && ccw341 * ccw342 == 0) {
			if (ccw123 == 0 && ccw124 == 0 && ccw341 == 0 && ccw342 == 0) {
				sortPoints(p1, p2, p3, p4);			
				
				if (isSame(p1, p4) || isSame(p2, p3)) {
					sb.append(1).append("\n");
					
					Point intersection = getIntersectionOnEndOfLine(p1, p2, p3, p4);
					sb.append(intersection.x).append(" ").append(intersection.y);
				} else if (isSmall(p1, p4) && isSmall(p3, p2)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}			
			} else {
				sb.append(1).append("\n");
				
				Point intersection = getIntersectionOnEndOfLine(p1, p2, p3, p4);
				sb.append(intersection.x).append(" ").append(intersection.y);
			}
		} else {
			sb.append(0).append("\n");
		}
				
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static double[] getIntersectionNotEndOfLine(Point p1, Point p2, Point p3, Point p4) {
		double[] intersection = new double [2];
		
		if (canMakeSlope(p1, p2) && canMakeSlope(p3, p4)) {
			double slope1 = getSlope(p1, p2);
			double slope2 = getSlope(p3, p4);
			intersection[0] = (slope1 * p1.x - slope2 * p3.x + p3.y - p1.y) / (slope1 - slope2);
			intersection[1] = slope1 * (intersection[0] - p1.x) + p1.y;
		} else if (canMakeSlope(p1, p2)) {
			double slope = getSlope(p1, p2);
			intersection[0] = p3.x;
			intersection[1] = slope * (p3.x - p1.x) + p1.y;
		} else if (canMakeSlope(p3, p4)) {
			double slope = getSlope(p3, p4);
			intersection[0] = p1.x;
			intersection[1] = slope * (p1.x - p3.x) + p3.y;			
		}
		
		return intersection;
	}

	private static double getSlope(Point p1, Point p2) {
		return ((double) p2.y - p1.y) / (p2.x - p1.x);
	}

	private static boolean canMakeSlope(Point p1, Point p2) {
		return p1.x != p2.x;
	}

	private static Point getIntersectionOnEndOfLine(Point p1, Point p2, Point p3, Point p4) {
		Point interseciton = null;
		if (p1.x == p3.x && p1.y == p3.y) {
			interseciton = new Point(p1.x, p1.y);
		} else if (p1.x == p4.x && p1.y == p4.y) {
			interseciton = new Point(p1.x, p1.y);			
		} else if (p2.x == p3.x && p2.y == p3.y) {
			interseciton = new Point(p2.x, p2.y);			
		} else if (p2.x == p4.x && p2.y == p4.y) {
			interseciton = new Point(p2.x, p2.y);			
		}
		return interseciton;
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