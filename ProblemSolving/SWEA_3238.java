import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3238 {
	static long n, r, result;
	static int p, tmpN, tmpR;
	static long fact[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Long.parseLong(st.nextToken());
			r = Long.parseLong(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			result = 1;
			fact = new long[p + 1];
			fact[0] = 1;		
			for (int i = 1; i <= p; i++)
				fact[i] = (fact[i - 1] * i) % p;
			while(n != 0 || r != 0) {
				tmpN = (int) (n % p);
				tmpR = (int) (r % p);
				if(tmpN < tmpR) {
					result = 0;
					break;
				}
				result = ( ((result*fact[tmpN]) % p) * (pow((fact[tmpR] * fact[tmpN - tmpR]) % p, p-2, p) % p) ) % p;
				n /= p; r /= p;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
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