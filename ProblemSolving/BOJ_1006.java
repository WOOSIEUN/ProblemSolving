import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1006 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] base = new int [N][2];
			StringTokenizer first = new StringTokenizer(br.readLine());
			StringTokenizer second = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				base[i][0] = Integer.parseInt(first.nextToken());
				base[i][1] = Integer.parseInt(second.nextToken());
			}
			
			int ans = Integer.MAX_VALUE;
			int[] none = new int [N + 1];
			int[] firstRow = new int [N + 1];
			int[] secondRow = new int [N + 1];
						
			none[0] = 0;
			firstRow[0] = 1;
			secondRow[0] = 1;
            solve(0, base, none, firstRow, secondRow, W);
	        ans = Math.min(ans, none[N]);

	        if (N == 1) {
	        	sb.append(ans).append("\n");
	        	continue;
	        }

	        if ((base[0][0] + base[N - 1][0]) <= W) {
	        	none[1] = 1;
	            firstRow[1] = 2;
	            secondRow[1] = ((base[0][1] + base[1][1]) <= W ? 1 : 2);
	            
	            solve(1, base, none, firstRow, secondRow, W);
	            ans = Math.min(ans, secondRow[N - 1] + 1);
	        }

	        if ((base[0][1] + base[N - 1][1]) <= W) {
	            none[1] = 1;
	            firstRow[1] = ((base[0][0] + base[1][0]) <= W ? 1 : 2);
	            secondRow[1] = 2;
	            
	            solve(1, base, none, firstRow, secondRow, W);
	            ans = Math.min(ans, firstRow[N - 1] + 1);
	        }

	        if ((base[0][0] + base[N - 1][0]) <= W && (base[0][1] + base[N - 1][1]) <= W) {
	            none[1] = 0;
	            firstRow[1] = 1;
	            secondRow[1] = 1;
	            
	            solve(1, base, none, firstRow, secondRow, W);
	            ans = Math.min(ans, none[N - 1] + 2);
	        }
	        
	        sb.append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void solve(int start, int[][] base, int[] none, int[] firstRow, int[] secondRow, int W) {
		for (int i = start; i < base.length; i++) {
			none[i + 1] = Math.min(firstRow[i] + 1, secondRow[i] + 1);
			
	        if (base[i][0] + base[i][1] <= W) {
				none[i + 1] = Math.min(none[i + 1], none[i] + 1);
	        }
	        
	        if (i > 0 && (base[i - 1][0] + base[i][0]) <= W && (base[i - 1][1] + base[i][1]) <= W) {
		        none[i + 1] = Math.min(none[i + 1], none[i - 1] + 2);	        	
	        }
	        
	        if (i < base.length - 1) {
	        	firstRow[i + 1] = none[i + 1] + 1;	            
	            if ((base[i][0] + base[i + 1][0]) <= W) {
	            	firstRow[i + 1] = Math.min(firstRow[i + 1], secondRow[i] + 1);
	            }
	            
	            secondRow[i + 1] = none[i + 1] + 1;
	            if ((base[i][1] + base[i + 1][1]) <= W) {
	                secondRow[i + 1] = Math.min(secondRow[i + 1], firstRow[i] + 1);
	            }
	        }
	    }
	}
}
