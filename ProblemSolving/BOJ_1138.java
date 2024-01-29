import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] tallerThanMe = new int [N];
		ArrayList<Integer> line = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tallerThanMe[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N - 1; i >= 0; i--) {
            line.add(tallerThanMe[i], i + 1);
        }

		for (int i = 0; i < N; i++) {
			sb.append(line.get(i)).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
