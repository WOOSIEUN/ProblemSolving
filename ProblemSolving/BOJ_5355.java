import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5355 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			double num = Double.parseDouble(st.nextToken());
			
			while (st.hasMoreTokens()) {
				char operator = st.nextToken().charAt(0);
				
				if (operator == '@') {
					num *= 3;
				} else if (operator == '%') {
					num += 5;
				} else {
					num -= 7;
				}
			}
			
			sb.append(String.format("%.2f", num)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
