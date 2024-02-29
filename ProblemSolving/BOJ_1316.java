import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BOJ_1316 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int groupWord = 0;
		HashSet<Character> alpabet;
		
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			char[] str = br.readLine().toCharArray();
			alpabet = new HashSet<>();
			boolean isGroupWord = true;
			
			for (int i = 0; i < str.length; i++) {
				if (!alpabet.contains(str[i])) {
					alpabet.add(str[i]);
				} else {
					if (str[i - 1] != str[i]) {
						isGroupWord = false;
						break;
					}
				}
			}
			
			groupWord += (isGroupWord ? 1 : 0);
		}
		
		bw.write(String.valueOf(groupWord));
		br.close();
		bw.close();
	}
}
