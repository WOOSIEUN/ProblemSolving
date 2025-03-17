import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] DNAs = new char[N][M];
        for (int i = 0; i < N; i++) {
            DNAs[i] = br.readLine().toCharArray();
        }

        Map<Character, Integer> charToIdx = new HashMap<>();
        charToIdx.putAll(new HashMap<Character, Integer>() {{
            put('A', 0);
            put('T', 3);
            put('G', 2);
            put('C', 1);
        }});

        Map<Integer, Character> idxToChar = new HashMap<>();
        idxToChar.putAll(new HashMap<Integer, Character>() {{
            put(0, 'A');
            put(3, 'T');
            put(2, 'G');
            put(1, 'C');
        }});

        int hammingCode = 0;
        int[] cnt;
        StringBuilder sb = new StringBuilder();
        for (int curIdx = 0; curIdx < M; curIdx++) {
            cnt = new int[4];
            for (int curStr = 0; curStr < N; curStr++) {
                cnt[charToIdx.get(DNAs[curStr][curIdx])]++;
            }

            int max = -1, maxIdx = -1;
            for (int j = 0; j < cnt.length; j++) {
                if (max < cnt[j]) {
                    max = cnt[j];
                    maxIdx = j;
                }
            }
            sb.append(idxToChar.get(maxIdx));
            hammingCode += (N - max);
        }

        sb.append("\n").append(hammingCode);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
