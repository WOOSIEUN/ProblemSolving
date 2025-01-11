import java.io.*;
import java.util.*;

public class BOJ_26004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('H', 0);
        map.put('I', 0);
        map.put('A', 0);
        map.put('R', 0);
        map.put('C', 0);

        for (char c : str) {
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        List<Integer> cntOfItem = new ArrayList<>(map.values());
        Collections.sort(cntOfItem);

        bw.write(String.valueOf(cntOfItem.get(0)));
        br.close();
        bw.close();
    }

    private static boolean isInArray(char[] emoji, char c) {
        for (char el : emoji) {
            if (el == c) {
                return true;
            }
        }
        return false;
    }
}
