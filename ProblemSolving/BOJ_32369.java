import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_32369 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int praiseOnion = 1, blameOnion = 1;
		for (int i = 0; i < N; i++) {

			praiseOnion += A;
			blameOnion += B;
			
			if (praiseOnion < blameOnion) {
				int tmp = praiseOnion;
				praiseOnion = blameOnion;
				blameOnion = tmp;
			}

			if (praiseOnion == blameOnion) {
				blameOnion--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(praiseOnion).append(" ").append(blameOnion);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
