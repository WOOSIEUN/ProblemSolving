import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19949 {

    static final int MAX_PROBLEM = 10;
    static final int CRITERIA = 5;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[MAX_PROBLEM];
        for (int i = 0; i < MAX_PROBLEM; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        int[] input = new int[MAX_PROBLEM];
        combi(0, input, answer);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void combi(int idx, int[] input, int[] answer) {
        if (idx == MAX_PROBLEM) {
            int correctCnt = getCorrectCnt(input, answer);
            if (correctCnt >= CRITERIA) {
                ans++;
            }
            return;
        }

        for (int pickedNumber = 1; pickedNumber < 6; pickedNumber++) {
            if (idx > 1 && input[idx - 1] == pickedNumber && input[idx - 2] == pickedNumber) {
                continue;
            }

            input[idx] = pickedNumber;
            combi(idx + 1, input, answer);
        }
    }

    private static int getCorrectCnt(int[] input, int[] answer) {
        int correctCnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == answer[i]) {
                correctCnt++;
            }
        }
        return correctCnt;
    }
}
