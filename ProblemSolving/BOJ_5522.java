import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int numOfNums = 5;
		int sum = 0;
		for (int i = 0; i < numOfNums; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}
}