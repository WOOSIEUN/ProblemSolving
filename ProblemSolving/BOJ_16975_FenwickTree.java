import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16975_FenwickTree {
	static class FenwickTree {
		private long[] tree;
		
		public FenwickTree(int N) {
			tree = new long [N];
		}
		
		private long sum(int idx) {
			long result = 0;
			while (idx > 0) {
				result += tree[idx];
				idx &= idx - 1;
			}
			return result;	
		}
		
		private void update(int idx, int value) {
			while (idx < tree.length) {
				tree[idx] += value;
				idx += (idx & -idx);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
        FenwickTree fenwickTree = new FenwickTree(N + 1);
        
        st = new StringTokenizer(br.readLine());
        int prev = -1, now = Integer.parseInt(st.nextToken());
		fenwickTree.update(1, now);
        for(int i = 2; i <= N; i++) {
			prev = now;
			now = Integer.parseInt(st.nextToken());
			fenwickTree.update(i, now - prev);
		}

		int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				fenwickTree.update(b, d);
				fenwickTree.update(c + 1, -d);
			} else {
				sb.append(fenwickTree.sum(b)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
