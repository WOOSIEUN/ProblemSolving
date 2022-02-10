import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1233 {
	static String[] tree;
	static int vaild, N, cur, mid;
//	static String left,right;
//	static Stack<String> s = new Stack<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			vaild = 1;
//			s.clear();
			N = Integer.parseInt(br.readLine());
			mid = N/2;
			tree = new String[N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			for (int i = 1; i < N+1; i++) {
				cur = tree[i].charAt(0);
				if (0 <= cur - '0' && cur - '0' <= 9) {
					if (i <= mid) {
						vaild = 0;
						break;
					}
				} else {
					if (i > mid) {
						vaild = 0;
						break;
					}
				}
			}
			result.append("#"+t+" "+vaild+"\n");
		}
		bw.write(result.toString());
		br.close();
		bw.close();
	}
//	
//	static void dfsByPostOrder(int current) {
//		if(current>N) return;
//
//		//현재 노드의 자식 노드들 방문
//		dfsByPostOrder(current*2);
//		dfsByPostOrder(current*2+1);
//		//현재 노드 방문
//		cur = tree[current].charAt(0);
//		if (0 <= cur - '0' && cur - '0' <= 9) {
//			s.add(tree[current]);
//		} else {
//			left = s.pop();
//			right = s.pop();
//			if()
//			if(cur == '+') s.add(String.valueOf(left + right));
//			else if(cur == '-') s.add(String.valueOf(left - right));
//			else if(cur == '*') s.add(String.valueOf(left * right));
//			else if(cur == '/') s.add(String.valueOf(left / right));
//		}
//		System.out.print(tree[current]+" ");
//	}
//
//	static int isvaild(int i) {
//		dfsByPostOrder(1);
//		return 1;
//	}
}
