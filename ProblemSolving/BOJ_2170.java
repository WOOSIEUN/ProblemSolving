import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170 {
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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point [N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(points, (p1, p2) -> (p1.x == p2.x ? (p1.y - p2.y) : (p1.x - p2.x)));
		
		int start = points[0].x, end = points[0].y;
		int len = end - start;
		for (int cur = 1; cur < N; cur++) {
			if (points[cur].y <= end) {
				continue;
			} else if (points[cur].x < end) {
				len += (points[cur].y - end);
			} else {
				len += (points[cur].y - points[cur].x);
			}
			
			start = points[cur].x;
			end = points[cur].y;
		}
		
		bw.write(String.valueOf(len));
		br.close();
		bw.close();
	}
}
