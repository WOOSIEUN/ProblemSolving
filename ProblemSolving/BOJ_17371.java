import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17371 {
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
		Point[] convenience = new Point [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			convenience[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int ans = -1;
		double minDist = Double.MAX_VALUE;
	    for (int cur = 0; cur < N; cur++) {
	        double maxDist = 0;
	        
	        for (int j = 0; j < N; j++) {
	            double dist = Math.sqrt(Math.pow(convenience[cur].x - convenience[j].x, 2) + Math.pow(convenience[cur].y - convenience[j].y, 2));
	            maxDist = Math.max(maxDist, dist);
	        }
	        
	        if (maxDist < minDist) {
	            ans = cur;
	            minDist = maxDist;
	        }
	    }
		
		bw.write(convenience[ans].x + " " + convenience[ans].y);
		br.close();
		bw.close();
	}
}
