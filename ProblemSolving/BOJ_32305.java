import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_32305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numOfApples = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		int numOfDozens = numOfApples / 12 + (numOfApples % 12 == 0 ? 0 : 1);
		
		bw.write(String.valueOf(numOfDozens * Integer.parseInt(br.readLine())));
		br.close();
		bw.close();
	}
}
