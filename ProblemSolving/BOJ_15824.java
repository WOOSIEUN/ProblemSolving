import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15824 {
    static final int MOD = 1_000_000_007;
    static long[] power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] scoville = new int[N];
        power = new long[N];
        power[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scoville[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scoville);

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (scoville[i] * power(2, i) - scoville[i] * power(2, N - i - 1));
            ans %= MOD;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static long power(long num, int x) {
        if (power[x] != 0) {
            return power[x];
        }

        long half = power(num, x / 2);
        if (x % 2 == 0) {
            return power[x] = half * half % MOD;
        } else {
            return power[x] = ((half * half) % MOD) * num % MOD;
        }
    }
}
