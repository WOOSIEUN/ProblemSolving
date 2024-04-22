import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7578 {
	static class FenwickTree {
		long[] tree;
		
		public FenwickTree(int N) {
			tree = new long [N];
		}
		
		long sum(int idx) {
			long result = 0;
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		FenwickTree fenwickTree = new FenwickTree(N + 1);
		
		HashMap<Integer, Integer> rowA = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			rowA.put(Integer.parseInt(st.nextToken()), i);
		}
        
		TreeMap<Integer, Integer> rowB = new TreeMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			rowB.put(rowA.get(Integer.parseInt(st.nextToken())), i);
		}
		
		long answer = 0;
		for (int key : rowB.keySet()) {
			int value = rowB.get(key);
			fenwickTree.update(value, 1);
			answer += (key - fenwickTree.sum(value));
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
