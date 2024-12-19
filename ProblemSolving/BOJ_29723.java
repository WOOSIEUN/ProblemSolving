import java.io.*;
import java.util.*;

public class BOJ_29723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> subjectMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            subjectMap.put(subject,score);
        }

        int baseScore = 0;
        for (int i = 0; i < K; i++, M--) {
            String subject = br.readLine();
            baseScore += subjectMap.get(subject);
            subjectMap.remove(subject);
        }

        List<Integer> scorelist = new ArrayList<>(subjectMap.values());
        Collections.sort(scorelist);

        int minScore = baseScore, maxScore = baseScore;
        for (int minIdx = 0, maxIdx = scorelist.size() - 1; minIdx < M; minIdx++, maxIdx--) {
            minScore += scorelist.get(minIdx);
            maxScore += scorelist.get(maxIdx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(maxScore);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
