import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4635 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == -1) {
				break;
			}
			
			int total = 0, prevTime = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());				
				int speed = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				total += (time - prevTime) * speed;
				prevTime = time;
			}
			
			sb.append(total).append(" miles\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
