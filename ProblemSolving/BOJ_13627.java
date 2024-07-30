import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13627 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean[] returnStatus = new boolean [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			returnStatus[Integer.parseInt(st.nextToken())] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (!returnStatus[i]) {
				sb.append(i).append(" ");
			}
		}
		
		bw.write(sb.length() == 0 ? "*" : sb.toString());
		br.close();
		bw.close();
	}
}
