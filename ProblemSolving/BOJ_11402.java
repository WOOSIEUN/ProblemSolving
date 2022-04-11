import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11402 {
	static long N, K, result;
	static int M, tmpN, tmpR;
	static long fact[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 1;
		fact = new long[M + 1];
		fact[0] = 1;		
		for (int i = 1; i <= M; i++)
			fact[i] = (fact[i - 1] * i) % M;
		while(N != 0 || K != 0) {
			tmpN = (int) (N % M);
			tmpR = (int) (K % M);
			if(tmpN < tmpR) {
				result = 0;
				break;
			}
			result = ( ((result*fact[tmpN]) % M) * (pow((fact[tmpR] * fact[tmpN - tmpR]) % M, M-2, M) % M) ) % M;
			N /= M; K /= M;
		}
		bw.write(""+result);
		br.close();
		bw.close();
	}

	private static long pow(long a, int b, int MOD) {
		if(b == 0) return 1;		
		else if(b == 1) return a;		
		if(b % 2 == 0) {
			long tmp = pow(a, b/2, MOD);
			return (tmp * tmp) % MOD;
		} else {
			long tmp = pow(a, b-1, MOD) % MOD;
			return (tmp * a) % MOD;
		}
	}
}