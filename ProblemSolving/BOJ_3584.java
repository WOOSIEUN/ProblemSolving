import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3584 {
	static int [] tree;
	static Stack<Integer> n1Stack, n2Stack;
	static int n1, n2, parent, child, lca;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				parent = Integer.parseInt(st.nextToken());
				child = Integer.parseInt(st.nextToken());
				tree[child] = parent;
			}
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());			
			n1Stack = new Stack<Integer>();
			n2Stack = new Stack<Integer>();
			while (tree[n1] != 0) {
				n1Stack.add(n1);
				n1 = tree[n1];
			}
			n1Stack.add(n1);
			while (tree[n2] != 0) {
				n2Stack.add(n2);
				n2 = tree[n2];
			}
			n2Stack.add(n2);
			while(true) {
				if(!n1Stack.isEmpty() && !n2Stack.isEmpty()) {
					n1 = n1Stack.pop();
					n2 = n2Stack.pop();					
					if(n1 != n2) {
						break;
					}
					lca = n1;
				} else break;
				
			};
			sb.append(lca + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
