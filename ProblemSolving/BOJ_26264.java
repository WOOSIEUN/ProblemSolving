import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] memo = br.readLine().toCharArray();

        int numOfBigdata = 0;
        for (char c : memo) {
            numOfBigdata += (c == 'b' ? 1 : 0);
        }

        int numOfSecurity = (memo.length - (numOfBigdata * 7)) / 8;

        bw.write(numOfBigdata > numOfSecurity ? "bigdata?" : numOfBigdata < numOfSecurity ? "security!" : "bigdata? security!");
        br.close();
        bw.close();
    }
}
