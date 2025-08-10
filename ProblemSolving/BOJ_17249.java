import java.io.*;

public class BOJ_17249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] taeboInput = br.readLine().toCharArray();

        int left = 0, right = 0;
        boolean isLeft = true;
        for (char c : taeboInput) {
            if (c == '(') {
                isLeft = false;
            }

            if (c == '@') {
                if (isLeft) {
                    left++;
                } else {
                    right++;
                }
            }
        }

        bw.write(String.format("%d %d", left, right));
        br.close();
        bw.close();
    }
}
