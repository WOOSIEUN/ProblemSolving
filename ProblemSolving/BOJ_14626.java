import java.io.*;

public class BOJ_14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] isbn = br.readLine().toCharArray();

        int targetIdx = -1, sum = 0;
        for (int i = 0; i < isbn.length; i++) {
            if (isbn[i] == '*') {
                targetIdx = i;
            } else {
                sum += (i % 2 == 0 ? isbn[i] - '0' : (isbn[i] - '0') * 3);
            }
        }

        bw.write(String.valueOf(getTargetNumber(targetIdx, sum)));
        br.close();
        bw.close();
    }

    private static int getTargetNumber(int targetIdx, int sum) {
        for (int i = 0; i < 10; i++) {
            if ((targetIdx % 2 == 0 && (sum + i) % 10 == 0) || (targetIdx % 2 != 0 && (sum + 3 * i) % 10 == 0)) {
                return i;
            }
        }
        return -1;
    }
}
