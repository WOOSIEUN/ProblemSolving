import java.io.*;
import java.util.*;

public class BOJ_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequencyList = new ArrayList<>(map.keySet());
        Collections.sort(frequencyList, (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return list.indexOf(a) - list.indexOf(b);
            }
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for (int item : frequencyList) {
            for (int i = 0; i < map.get(item); i++) {
                sb.append(item + " ");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
