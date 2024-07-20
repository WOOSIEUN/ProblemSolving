import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int chicken = Integer.parseInt(st.nextToken());
		int beef = Integer.parseInt(st.nextToken());
		int pasta = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int requiredChicken = Integer.parseInt(st.nextToken());
		int requiredBeef = Integer.parseInt(st.nextToken());
		int requiredPasta = Integer.parseInt(st.nextToken());

		int ans = 0;
		ans += (requiredChicken - chicken > 0 ? requiredChicken - chicken : 0);
		ans += (requiredBeef - beef > 0 ? requiredBeef - beef : 0);
		ans += (requiredPasta - pasta > 0 ? requiredPasta - pasta : 0);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
