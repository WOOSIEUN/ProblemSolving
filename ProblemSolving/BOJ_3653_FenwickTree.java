import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3653_FenwickTree {
	static class FenwickTree {
		int[] tree;
		
		public FenwickTree(int N) {
			tree = new int [N];
		}
		
		int sum(int idx) {
			int result = 0;
			while (idx > 0) {
				result += tree[idx];
				idx &= idx - 1;
			}
			return result;	
		}
		
		void update(int idx, int value) {
			while (idx < tree.length) {
				tree[idx] += value;
				idx += (idx & -idx);
			}
		}
	}
	
	static int[] movieIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int arrLen = n + m;
			
			FenwickTree fenwickTree = new FenwickTree(arrLen + 1);			
			movieIdx = new int [n + 1];
			for (int i = 1; i <= n; i++) {
				movieIdx[i] = m + i;
				fenwickTree.update(movieIdx[i], 1);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int movie = Integer.parseInt(st.nextToken());
				sb.append(fenwickTree.sum(movieIdx[movie] - 1)).append(" ");
				
				fenwickTree.update(movieIdx[movie], -1);
				movieIdx[movie] = m - i;
				fenwickTree.update(movieIdx[movie], 1);
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
