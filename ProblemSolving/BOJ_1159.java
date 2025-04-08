import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] firstAlpabet = new int[26];
		
		for (int i = 0; i < N; i++) {
			firstAlpabet[br.readLine().charAt(0) - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < firstAlpabet.length; i++) {
			if (firstAlpabet[i] >= 5) {
				sb.append((char) (i + 'a'));
			}
		}
	    
		bw.write(sb.length() == 0 ? "PREDAJA" : sb.toString());
		br.close();
		bw.close();
	}
}
