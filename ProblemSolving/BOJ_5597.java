import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] submissionStatus = new boolean [31];
		for (int i = 0; i < 28; i++) {
			submissionStatus[Integer.parseInt(br.readLine())] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 31; i++) {
			if (!submissionStatus[i]) {
				sb.append(i).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
