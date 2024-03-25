import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			
			int res = 1;
			for (int i = 1; i <= b; i++) {
				res = res * a % 10;
			}
			
			sb.append(res == 0 ? 10 : res).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
