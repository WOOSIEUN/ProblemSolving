import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sumOfPrice = Integer.parseInt(br.readLine());
		for (int i = 0; i < 9; i++) {
			sumOfPrice -= Integer.parseInt(br.readLine());
		}
		
		bw.write(String.valueOf(sumOfPrice));
		br.close();
		bw.close();
	}
}
