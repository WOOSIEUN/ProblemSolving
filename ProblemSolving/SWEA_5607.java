import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5607 {
	static int N,R, MOD = 89329;
	static long fact[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			fact = new long[N + 1];
			fact[0] = 1;		
			for (int i = 1; i <= N; i++)
				fact[i] = (fact[i - 1] * i) % MOD;
			long bottom = (fact[R] * fact[N-R]) % MOD;
			bottom = pow(bottom, MOD -2);			
			sb.append("#").append(t).append(" ").append((fact[N]*bottom) % MOD).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static long pow(long a, int b) {
		if(b == 0) return 1;		
		else if(b == 1) return a;		
		if(b % 2 == 0) {
			long tmp = pow(a, b/2);
			return (tmp * tmp) % MOD;
		} else {
			long tmp = pow(a, b-1) % MOD;
			return (tmp * a) % MOD;
		}
	}
}
