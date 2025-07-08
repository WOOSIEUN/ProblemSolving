import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String firstWord = st.nextToken();
			String secondWord = st.nextToken();
			sb.append(firstWord).append(" & ").append(secondWord).append(" are")
				.append(isAnagram(countAlpabet(firstWord), countAlpabet(secondWord)) ? "" : " NOT").append(" anagrams.\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static boolean isAnagram(int[] countSource, int[] countTarget) {
		for (int i = 0; i < countSource.length; i++) {
			if (countSource[i] != countTarget[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] countAlpabet(String word) {
		int[] alpabet = new int[26];
		for (char c : word.toCharArray()) {
			alpabet[c - 'a']++;
		}
		return alpabet;
	}
}
