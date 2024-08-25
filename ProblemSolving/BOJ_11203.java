import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		char[] cmds = new char [0];
		if (st.hasMoreTokens()) {
			cmds = st.nextToken().toCharArray();
		}
		
		int cur = 1;
		for (char cmd : cmds) {
			if (cmd == 'L') {
				cur *= 2;
			} else {
				cur = cur * 2 + 1;
			}
		}
		
		bw.write(String.valueOf((1 << N + 1) - cur));
		br.close();
		bw.close();
	}
}
