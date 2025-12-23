import java.io.*;

public class BOJ_33869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int NUMS = 26;
        boolean[] used = new boolean[NUMS];
        char[] keyWord = br.readLine().toCharArray();

        char[] encryptionTable = new char[NUMS];
        int usedIdx = 0, keywordIdx = 0;
        for (int i = 0; i < NUMS; i++) {
            if (keyWord.length > keywordIdx) {
                while (keywordIdx < keyWord.length && used[keyWord[keywordIdx] - 'A']) {
                    keywordIdx++;
                }
                if (keywordIdx == keyWord.length) {
                    i--;
                    continue;
                }
                encryptionTable[i] = keyWord[keywordIdx++];
                used[encryptionTable[i] - 'A'] = true;
            } else {
                while (used[usedIdx]) {
                    usedIdx++;
                }
                encryptionTable[i] = (char) (usedIdx + 'A');
                used[usedIdx] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] target = br.readLine().toCharArray();
        for (int i = 0; i < target.length; i++) {
            sb.append(encryptionTable[target[i] - 'A']);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
