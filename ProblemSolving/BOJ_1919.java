import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] A = br.readLine().toCharArray();
		int[] alpabetA = new int [26];
		for (int i = 0; i < A.length; i++) {
			alpabetA[A[i] - 'a']++;
		}

		char[] B = br.readLine().toCharArray();
		int[] alpabetB = new int [26];
		for (int i = 0; i < B.length; i++) {
			alpabetB[B[i] - 'a']++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(alpabetA[i] - alpabetB[i]);
		}
		
		bw.write(String.valueOf(cnt));
		br.close();
		bw.close();
	}
}
