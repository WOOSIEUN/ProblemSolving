import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class BOJ_35479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigDecimal R = new BigDecimal(Integer.parseInt(st.nextToken()));
        BigDecimal G = new BigDecimal(Integer.parseInt(st.nextToken()));
        BigDecimal B = new BigDecimal(Integer.parseInt(st.nextToken()));

        BigDecimal RApo = R.divide(BigDecimal.valueOf(255), 10, RoundingMode.HALF_UP);
        BigDecimal GApo = G.divide(BigDecimal.valueOf(255), 10, RoundingMode.HALF_UP);
        BigDecimal BApo = B.divide(BigDecimal.valueOf(255), 10, RoundingMode.HALF_UP);
        BigDecimal max = RApo.max(GApo).max(BApo);
        BigDecimal K = BigDecimal.ONE.subtract(max);

        BigDecimal C, M, Y;
        if (K.compareTo(BigDecimal.ONE) == 0) {
            C = BigDecimal.ZERO;
            M = BigDecimal.ZERO;
            Y = BigDecimal.ZERO;
        } else {
            BigDecimal oneMinusK = BigDecimal.ONE.subtract(K);
            C = BigDecimal.ONE.subtract(RApo).subtract(K).divide(oneMinusK, 10, RoundingMode.HALF_UP);
            M = BigDecimal.ONE.subtract(GApo).subtract(K).divide(oneMinusK, 10, RoundingMode.HALF_UP);
            Y = BigDecimal.ONE.subtract(BApo).subtract(K).divide(oneMinusK, 10, RoundingMode.HALF_UP);
        }

        bw.write(C + " " + M + " " + Y + " " + K);
        br.close();
        bw.close();
    }
}
