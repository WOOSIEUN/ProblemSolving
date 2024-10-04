import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int attA = Integer.parseInt(st.nextToken());
		int hpA = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int attB = Integer.parseInt(st.nextToken());
		int hpB = Integer.parseInt(st.nextToken());
		
		while (hpA > 0 && hpB > 0) {
			hpA -= attB;
			hpB -= attA;
		}
		
		bw.write(hpA <= 0 ? (hpB <= 0 ? "DRAW" :"PLAYER B") : "PLAYER A");
		br.close();
		bw.close();
	}
}
