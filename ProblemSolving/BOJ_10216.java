import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10216 {
	
	static int[] parent;
	static int[][] cellTower;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			parent = new int [N];
			cellTower = new int [N][3];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				cellTower[i][0] = Integer.parseInt(st.nextToken());
				cellTower[i][1] = Integer.parseInt(st.nextToken());
				cellTower[i][2] = Integer.parseInt(st.nextToken());
				parent[i] = i;
			}
			
			int ans = N;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int xDiff = cellTower[i][0] - cellTower[j][0];
                    int yDiff = cellTower[i][1] - cellTower[j][1];
                    int r = cellTower[i][2] + cellTower[j][2];
					
                    if (xDiff * xDiff + yDiff * yDiff <= r * r) {
                    	if (find(i) == find(j)) {
                    		continue;
                    	}
                    	union(i, j);
                    	ans--;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a < b) {
            parent[b] = a;
		} else { 
            parent[a] = b;
        }
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
}
