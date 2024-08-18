import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16917 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        if (A + B < 2 * C) {
        	ans = A * X + B * Y;
        } else {
        	ans = 2 * C * Math.min(X, Y);
        	
        	if (X > Y) {
        		ans += Math.min(A * (X - Y), 2 * C * (X - Y));
        	} else {
        		ans += Math.min(B * (Y - X), 2 * C * (Y - X));        		
        	}
        }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
