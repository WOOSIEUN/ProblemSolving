import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int C = Integer.parseInt(br.readLine());
			
			sb.append(C / 25).append(" ");
			C %= 25;
			
			sb.append(C / 10).append(" ");
			C %= 10;
			
			sb.append(C / 5).append(" ");
			C %= 5;
			
			sb.append(C).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
