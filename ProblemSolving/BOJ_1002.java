import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
 
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			sb.append(getNumOfPositions(x1, y1, r1, x2, y2, r2)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int getNumOfPositions(int x1, int y1, int r1, int x2, int y2, int r2) {
		if (x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}
		
		int dist = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));		
		if (dist == Math.pow(r2 - r1, 2) || dist == Math.pow(r1 + r2, 2)) {
			return 1;
		} else if (dist < Math.pow(r2 - r1, 2) || dist > Math.pow(r1 + r2, 2)) {
			return 0;
		}		
		return 2;
	}
}
