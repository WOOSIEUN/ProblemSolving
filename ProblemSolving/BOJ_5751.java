import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while ((Integer.parseInt(br.readLine())) != 0) {
			st = new StringTokenizer(br.readLine());
			int john = 0, mary = 0;
			while (st.hasMoreTokens()) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					john++;
				} else {
					mary++;
				}
			}
			sb.append("Mary won ").append(mary).append(" times and John won ").append(john).append(" times\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
