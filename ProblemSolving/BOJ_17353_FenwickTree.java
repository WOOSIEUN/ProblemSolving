import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17353_FenwickTree {
	static class FenwickTree {
		private long[] cntTree, sumTree;
		
		public FenwickTree(int N) {
			cntTree = new long [N];
			sumTree = new long [N];
		}
		
		private long[] query(int idx) {
			long cntResult = 0, sumResult = 0;
			while (idx > 0) {
				cntResult += cntTree[idx];
				sumResult += sumTree[idx];
			    idx -= (idx & -idx);
			}
			return new long[] {cntResult, sumResult};	
		}
		
		private long getNumOfShootingStars(int idx, int startValue) {
			long[] result = query(idx);
			return result[0] * (idx + 1) - result[1] + startValue;
		}
		
		private void update(int idx, long diff) {		     
		    while (idx < cntTree.length) {
		    	sumTree[idx] += diff;
		    	cntTree[idx] += (diff > 0) ? 1 : -1;
				idx += (idx & -idx);
		    }
		}

		private void rangeUpdate(int start, int end, long diff) {
		    update(start, diff);
		    update(end + 1, -diff);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] shootingStars = new int [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			shootingStars[i] = Integer.parseInt(st.nextToken());
		}
		
		FenwickTree fenwickTree = new FenwickTree(N + 1);

		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				fenwickTree.rangeUpdate(L, R, L);
			} else {
				int X = Integer.parseInt(st.nextToken());
				sb.append(fenwickTree.getNumOfShootingStars(X, shootingStars[X])).append('\n');
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
