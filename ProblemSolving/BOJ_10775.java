import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10775 {
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		parent = new int [G + 1];
		
		for (int i = 1; i < G + 1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			int airplane = Integer.parseInt(br.readLine());			
			int dockingGate = find(airplane);
			
			if (dockingGate == 0) {
				break;
			}
			
			ans++;
			union(dockingGate, dockingGate - 1);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			return;
		}
		
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}		
	}

	private static int find(int node) {
		if (parent[node] == node) {
			return node;
		}
				
		return parent[node] = find(parent[node]);
	}
}
