import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int numOf5 = N / 5, remain = N % 5;
		
		while (remain % 2 != 0) {
			numOf5--;			
			remain += 5;
			
			if (numOf5 < 0) {
				break;
			}
		}
		
		bw.write(numOf5 < 0 ? "-1" : String.valueOf(numOf5 + (remain / 2)));
		br.close();
		bw.close();
	}
}
