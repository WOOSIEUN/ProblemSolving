import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15650 {
	
	static int N, M;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean [N];
		sb = new StringBuilder();
		
		combination(0, 0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < N; i++) {
            	if (visited[i]) {
                	sb.append(i + 1).append(" ");
            	}
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) {
            	continue;
            }
            
            visited[i] = true;
            combination(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}
