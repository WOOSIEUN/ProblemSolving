#include <iostream>
using namespace std;
 
typedef unsigned long long ull;

ull power(ull base, ull exponent, ull mod) {
	ull result = 1;
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

bool millerRabinPrimalityTest(ull n, ull a) {
	if (a % n == 0) {
		return false;
	}

	ull k = n - 1;
	while (true) {
		ull poweredResult = power(a, k, n);
		
		if (poweredResult == n - 1) {
			return true;
		}

		if (k % 2 == 1) {
			return (poweredResult == 1 || poweredResult == n - 1);
		}

		k /= 2;
	}
}

bool isPrime(ull num) {
	ull primeNumbers[5] = {2, 3, 5, 7, 11};
	
    if (num <= 1 || (num != 2 && num % 2 == 0)) {
        return false;
    }
    
	for (auto& number : primeNumbers) {
		if (num == number) {
			return true;
		}
		if (!millerRabinPrimalityTest(num, number)) {
			return false;
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, ans = 0;
    cin >> N;
    for (int i = 0; i < N; i++) {
    	ull area;
    	cin >> area;
		if (isPrime(2 * area + 1)) {
			ans++;
		}
	}
	
	cout << ans;
	return 0;
}