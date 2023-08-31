import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int a, b, c;
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); 
			b = Integer.parseInt(st.nextToken()); 
			c = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			if (isRightAngledTriangle(a, b, c) || isRightAngledTriangle(b, c, a) || isRightAngledTriangle(c, a, b)) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static boolean isRightAngledTriangle(int a, int b, int c) {
		return (a * a + b * b) == c * c;
	}
}
