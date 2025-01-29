import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0, rank = 0; i < N; i++) {
            if (rankMap.containsKey(sortedArr[i])) {
                continue;
            }
            rankMap.put(sortedArr[i], rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int el : arr) {
            sb.append(rankMap.get(el)).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
