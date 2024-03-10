import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10162 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		sb.append(N / 300).append(" ");
		N %= 300;
		sb.append(N / 60).append(" ");
		N %= 60;
		sb.append(N / 10);
		N %= 10;
		
		bw.write(N == 0 ? sb.toString() : "-1");
		br.close();
		bw.close();
	}
}
