import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] word = br.readLine().toCharArray();	
		bw.write(isPalindrome(word) ? "1" : "0");
		br.close();
		bw.close();
	}

	private static boolean isPalindrome(char[] word) {
		for (int left = 0, right = word.length - 1; left <= right; left++, right--) {
			if (word[left] != word[right]) {
				return false;
			}
		}
		return true;
	}
}
