import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9772 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			if (x == 0 || y == 0) {
				sb.append("AXIS").append("\n");
			} else if (x > 0) {
				sb.append(y > 0 ? "Q1" : "Q4").append("\n");
			} else {
				sb.append(y > 0 ? "Q2" : "Q3").append("\n");
			}
			
			if (x == 0 && y == 0) {
				break;
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
