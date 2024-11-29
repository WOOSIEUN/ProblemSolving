import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_25640 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String mbti = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int same = 0;
		
		for (int i = 0; i < N; i++) {
			if (br.readLine().equals(mbti)) {
				same++;
			}
		}
		
		bw.write(String.valueOf(same));
		br.close();
		bw.close();
	}
}
