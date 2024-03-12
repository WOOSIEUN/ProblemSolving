import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4796 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int i = 1; ; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			if (L == 0 && P == 0 && V == 0) {
				break;
			}
			
			int ans = V / P * L;
			ans += ((V % P) > L ? L : V % P);
			sb.append("Case ").append(i).append(": ").append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
