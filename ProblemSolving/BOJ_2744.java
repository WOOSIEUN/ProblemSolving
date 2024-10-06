import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] word = br.readLine().toCharArray();
		for (int i = 0; i < word.length; i++) {
			word[i] = (isLowerCase(word[i]) ? toUpperCase(word[i]) : toLowerCase(word[i]));
		}
		
		bw.write(word);
		br.close();
		bw.close();
	}
	
	private static char toLowerCase(char target) {
		return (char) (target + ('a' - 'A'));
	}
	
	private static char toUpperCase(char target) {
		return (char) (target - ('a' - 'A'));
	}

	private static boolean isLowerCase(char target) {
		return 'a' <= target && target <= 'z';
	}
}
