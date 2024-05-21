import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11689 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		bw.write(String.valueOf(eulerPhi(Long.parseLong(br.readLine()))));
		br.close();
		bw.close();
	}
	
	private static long eulerPhi(long n) {
	    long euler = n;
	    
	    for (long p = 2; p * p <= n; p++){
			    if (n % p == 0) {
					    euler = euler / p * (p - 1);
				  }		    
	        while (n % p == 0) {
			        n /= p;
			    }
	    }
	    
	    return (n == 1 ? euler : euler / n * (n - 1));
	}
}
