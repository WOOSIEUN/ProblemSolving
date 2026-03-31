import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int ALPABET = 4;

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dnaString = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] required = new int [ALPABET];
        for (int i = 0; i < required.length; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int[] curCnt = new int [ALPABET];
        for (; end < P - 1; end++) {
            char c = dnaString[end];
            curCnt[toIndex(c)]++;
        }

        int ans = 0;
        for (; end < S; start++, end++) {
            char endChar = dnaString[end];
            curCnt[toIndex(endChar)]++;

            if (validDNAPassword(curCnt, required)) {
                ans++;
            }

            char startChar = dnaString[start];
            curCnt[toIndex(startChar)]--;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean validDNAPassword(int[] curCnt, int[] required) {
        for (int idx = 0; idx < curCnt.length; idx++) {
            if (curCnt[idx] < required[idx]) {
                return false;
            }
        }
        return true;
    }

    private static int toIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: throw new IllegalArgumentException();
        }
    }
}
