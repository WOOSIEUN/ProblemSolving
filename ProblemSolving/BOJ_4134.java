import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long prime = Long.parseLong(br.readLine());
            for (long i = prime; ; i++) {
                if (isPrime(i)) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }


    private static boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
