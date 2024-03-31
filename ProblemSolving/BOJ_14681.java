import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14681 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
		
        int ans = 0;
        if (x > 0 && y > 0) {
            ans = 1;
        } else if (x > 0) {
            ans = 4;
        } else if (y > 0) {
            ans = 2;
        } else {
            ans = 3;
        }
   
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}