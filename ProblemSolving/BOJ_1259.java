import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1259 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String num = br.readLine();
			
			if (Integer.parseInt(num) == 0) {
				break;
			}
			
			char[] numArr = num.toCharArray();
			boolean isPalindrome = true;
			for (int i = 0; i < numArr.length / 2; i++) {
				if (numArr[i] != numArr[numArr.length - i - 1]) {
					isPalindrome = false;
					break;
				}
			}
			
			sb.append(isPalindrome ? "yes\n" : "no\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
