import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5073 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			if (a >= b + c || b >= c + a || c >= a + b) {
				sb.append("Invalid\n");
			} else if (a == b && b == c && c == a) {
				sb.append("Equilateral\n");
			} else if (a == b || b == c || c == a) {
				sb.append("Isosceles\n");
			} else if (a != b && b != c && c != a) {
				sb.append("Scalene\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
