import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9184 {
	
	static final int MAX = 21;
	static int dp[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		dp = new int [MAX][MAX][MAX];
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int w(int a, int b, int c) {
		if (isInRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
	 
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
			
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	private static boolean isInRange(int a, int b, int c) {
		return 0 <= a && a < MAX && 0 <= b && b < MAX && 0 <= c && c < MAX;
	}
}
