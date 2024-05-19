import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String leftPattern = st.nextToken();
		String rightPattern = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			String target = br.readLine();
			if (leftPattern.length() + rightPattern.length() > target.length()) {
				sb.append("NE\n");
				continue;
			}
			
			String left = target.substring(0, leftPattern.length());
			String right = target.substring(target.length() - rightPattern.length(), target.length());
			sb.append((left.equals(leftPattern) && right.equals(rightPattern)) ? "DA\n" : "NE\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
