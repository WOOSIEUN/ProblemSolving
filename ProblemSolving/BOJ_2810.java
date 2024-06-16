import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] seats = br.readLine().toCharArray();
		
		int numOfCupHolder = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 'S') {
				numOfCupHolder++;
			}
		}
		
		numOfCupHolder += ((seats.length - numOfCupHolder) / 2) + 1;
		
		bw.write(numOfCupHolder > N ? String.valueOf(N) : String.valueOf(numOfCupHolder));
		br.close();
		bw.close();
	}
}
