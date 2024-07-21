import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int ans = 0;
        boolean[] seats = new boolean [101];
		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int requiredSeat = Integer.parseInt(st.nextToken());
            if (seats[requiredSeat]) {
                ans++;
            } else {
                seats[requiredSeat] = true;
            }
        }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}