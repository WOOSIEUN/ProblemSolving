import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] time = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
		
		int sumOfTime = 0;
		char[] word = br.readLine().toCharArray();
		for (char ch: word) {
			sumOfTime += time[ch - 'A'];
		}
		
		bw.write(String.valueOf(sumOfTime));
		br.close();
		bw.close();
	}
}
