import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fact(1, N)));
        br.close();
        bw.close();
    }

    private static BigInteger fact(int start, int end) {
        BigInteger num = BigInteger.valueOf(start);
        
        if (start < end){
            int mid = (start + end) / 2;
            num = fact(start, mid).multiply(fact(mid + 1, end));
        }
        return num;
    }
}
