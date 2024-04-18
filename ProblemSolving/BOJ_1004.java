import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken()); 
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int entryOrExitCount = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());			
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean hasStartContained = hasContained(startX, startY, x, y, r);
				boolean hasEndContained = hasContained(endX, endY, x, y, r);
				
				if (!(hasStartContained && hasEndContained) && (hasStartContained || hasEndContained)) {
					entryOrExitCount++;
				}
			}			
			sb.append(entryOrExitCount).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static boolean hasContained(int x, int y, int planetX, int planetY, int planetR) {
		return (int) (Math.pow(x - planetX, 2) + Math.pow(y - planetY, 2)) < (int) Math.pow(planetR, 2);
	}
}
