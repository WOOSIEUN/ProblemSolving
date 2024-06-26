import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10102 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] votes = br.readLine().toCharArray();
		int numOfA = 0;
		for (char vote : votes) {
			numOfA += (vote == 'A') ? 1 : 0;
		}
		
		bw.write((numOfA == N - numOfA ? "Tie" : (numOfA > N - numOfA ? "A" : "B")));
		br.close();
		bw.close();
	}
}
