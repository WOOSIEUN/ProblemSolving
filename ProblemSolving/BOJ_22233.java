import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_22233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> notepad = new HashSet<>();
		for (int i = 0; i < N; i++) {
			notepad.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreElements()) {
				notepad.remove(st.nextToken());
			}
			sb.append(notepad.size()).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
