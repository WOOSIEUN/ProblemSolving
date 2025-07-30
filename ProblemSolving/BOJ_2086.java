import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2086 {

    static final long MOD = 1_000_000_000L;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 0L);
        map.put(1L, 1L);

        bw.write(String.valueOf((fibonacci(B + 2) - fibonacci(A + 1) + MOD) % MOD));
        br.close();
        bw.close();
    }

    // 도가뉴 항등식(d'Ocagne's identity)
    private static long fibonacci(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        boolean isEven = n % 2 == 0;
        long k = n / 2;
        long fn = fibonacci(k);
        long fn1 = fibonacci(k + (isEven ? -1 : 1));

        long value;
        if (isEven) {
            value = (fn * ((2 * fn1 + fn) % MOD)) % MOD;
        } else {
            value = (fn * fn % MOD + fn1 * fn1 % MOD) % MOD;
        }

        map.put(n, value);
        return value;
    }
}
