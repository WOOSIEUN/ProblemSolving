import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11328 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] src = st.nextToken().toCharArray();
			char[] des = st.nextToken().toCharArray();
			
			int[] alphabetCnt = new int [26];
			for (char c : src) {
				alphabetCnt[c - 'a']++; 
			}
			
			for (char c : des) {
				alphabetCnt[c - 'a']--; 
			}
			
			boolean isPossible = true;
			for (int cnt : alphabetCnt) {
				if (cnt != 0) {
					isPossible = false;
					break;
				}
			}
			
			sb.append(isPossible ? "Possible" : "Impossible").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
