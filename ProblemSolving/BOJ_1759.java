import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L, C;
	static StringBuilder sb;
	static String [] alpabet;
	static boolean [] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpabet = new String [C];
		isSelected = new boolean [C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) alpabet[i] = st.nextToken();
		Arrays.sort(alpabet);
		password(0, 0, 0, 0);
		bw.write(sb.substring(0,sb.length()-1).toString());
		br.close();
		bw.close();
	}

	private static void password(int idx, int cnt, int consonant, int vowel) {
		if(cnt == L && consonant >= 2  && vowel >= 1) {
			for (int i = 0; i < C; i++)
				if(isSelected[i]) sb.append(alpabet[i]);
			sb.append("\n");
			return;
		} else if (idx == C) return;
		isSelected[idx] = true;
		if(isVowel(alpabet[idx])) password(idx + 1, cnt + 1, consonant, vowel + 1);
		else password(idx + 1, cnt + 1, consonant + 1, vowel);
		isSelected[idx] = false;
		password(idx + 1, cnt, consonant, vowel);
	}

	private static boolean isVowel(String s) {
		if(s.equals("a")||s.equals("e")||s.equals("u")||s.equals("i")||s.equals("o")) return true;
		return false;
	}	
	
}
