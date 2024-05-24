import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ_5615.c++과 같은 알고리즘이나, long과 unsigned long long의 범위 문제로 큰 수에서 오답 발생.
 * BigInteger 등으로 바꾸거나, 추후 수정이 필요함.
 */
public class BOJ_5615 {

	static final int[] primeNumbers = {2, 3, 5, 7, 11};

	private static long power(long base, long exponent, long mod) {
		long result = 1;
		base %= mod;

		while (exponent > 0) {
			if (exponent % 2 == 1) {
				result = (result * base) % mod;
			}
			base = (base * base) % mod;
			exponent /= 2;
		}

		return result;
	}

	private static boolean millerRabinPrimalityTest(long n, long a) {
		if (a % n == 0) {
			return false;
		}

		long k = n - 1;
		while (true) {
			long poweredResult = power(a, k, n);

			if (poweredResult == n - 1) {
				return true;
			}

			if (k % 2 == 1) {
				return (poweredResult == 1 || poweredResult == n - 1);
			}

			k /= 2;
		}
	}

	private static boolean isPrime(long num) {
	    if (num <= 1 || (num != 2 && num % 2 == 0)) {
	        return false;
	    }
	    
		for (int number : primeNumbers) {
			if (num == number) {
				return true;
			}

			if (!millerRabinPrimalityTest(num, number)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			long area = Long.parseLong(br.readLine());
			if (isPrime(2 * area + 1)) {
				ans++;
			}
		}

		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
