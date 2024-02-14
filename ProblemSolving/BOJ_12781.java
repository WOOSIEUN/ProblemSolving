import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12781 {
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
		
		Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int ans = 0;
		long firstRes = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		long secondRes = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if (firstRes < 0 && secondRes < 0) {
			ans = 1;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	private static int ccw(Point p1, Point p2, Point p3) {
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
