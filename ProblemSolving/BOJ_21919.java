import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_21919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] primeTable = buildPrimeTable(1_000_000);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (primeTable[num]) {
                set.add(num);
            }
        }

        long ans = 1;
        for (int prime : set) {
            ans *= prime;
        }

        bw.write(set.isEmpty() ? "-1" : String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean[] buildPrimeTable(int max) {
        boolean[] primeTable = new boolean[max + 1];
        Arrays.fill(primeTable, true);
        primeTable[0] = primeTable[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (primeTable[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primeTable[j] = false;
                }
            }
        }
        return primeTable;
    }
}
