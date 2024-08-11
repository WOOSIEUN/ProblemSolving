import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2490 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int back = 0;
			while (st.hasMoreTokens()) {
				back += (Integer.parseInt(st.nextToken()) == 1 ? 1 : 0);
			}
			
			if (back == 3) {
				sb.append("A").append("\n");
			} else if (back == 2) {
				sb.append("B").append("\n");
			} else if (back == 1) {
				sb.append("C").append("\n");
			} else if (back == 0) {
				sb.append("D").append("\n");
			} else {
				sb.append("E").append("\n");
			} 
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
