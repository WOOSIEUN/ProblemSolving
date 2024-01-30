import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String password = br.readLine();
			if (password.equals("end")) {
				break;
			}
			
			boolean isValid = false;
			int consonantCnt = 0, vowelCnt = 0;
			char prev = ' ';
			for (char cur : password.toCharArray()) {
				if (isVowel(cur)) {
					isValid = true;
					vowelCnt++;
					consonantCnt = 0;
				} else {
					consonantCnt++;
					vowelCnt = 0;
				}
				
				if (prev == cur && cur != 'e' && cur != 'o') {
					isValid = false;
					break;
				} else if (consonantCnt == 3 || vowelCnt == 3) {
					isValid = false;			
					break;	
				}
				
				prev = cur;
			}
			
			if (!isValid) {
				sb.append("<").append(password).append("> is not acceptable.\n");				
			} else {
				sb.append("<").append(password).append("> is acceptable.\n");						
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
