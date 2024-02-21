import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1013 {
	
	static final String pattern = "(100+1+|01)+";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append(br.readLine().matches(pattern) ? "YES\n" : "NO\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
