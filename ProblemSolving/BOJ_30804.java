import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] fruits = new int[N];
        HashMap<Integer, Integer> fruitMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int left = 0, right = 0; right < N; right++) {
            fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right], 0) + 1);

            while (fruitMap.size() > 2) {
                int curCnt = fruitMap.get(fruits[left]) - 1;
                if (curCnt == 0) {
                    fruitMap.remove(fruits[left]);
                } else {
                    fruitMap.put(fruits[left], curCnt);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
