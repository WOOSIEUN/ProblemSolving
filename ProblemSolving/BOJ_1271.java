import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(N.divide(M)).append("\n");
        sb.append(N.remainder(M));
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}