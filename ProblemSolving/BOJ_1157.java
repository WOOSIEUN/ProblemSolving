import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] str = br.readLine().toCharArray();
		int[] alphabet = new int [26];
		for (int i = 0; i < str.length; i++) {
			if ('A' <= str[i] && str[i] <= 'Z') {
				alphabet[str[i] - 'A']++;
			} else {
				alphabet[str[i] - 'a']++;
			}
		}
		
		int maxCnt = 0;
		char ch = '?';
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > maxCnt) {
				maxCnt = alphabet[i];
				ch = (char) ('A' + i);
			} else if (alphabet[i] == maxCnt) {
				ch = '?';
			}
		}
		
		bw.write(ch);
		br.close();
		bw.close();
	}
}
