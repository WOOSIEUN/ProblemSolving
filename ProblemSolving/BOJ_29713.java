import java.io.*;
import java.util.HashMap;
import java.util.Optional;
import java.util.StringTokenizer;

public class BOJ_29713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('B', 0);
        map.put('R', 0);
        map.put('O', 0);
        map.put('N', 0);
        map.put('Z', 0);
        map.put('E', 0);
        map.put('S', 0);
        map.put('I', 0);
        map.put('L', 0);
        map.put('V', 0);

        int N = Integer.parseInt(br.readLine());
        char[] seals = br.readLine().toCharArray();
        for (char seal: seals) {
            if (map.containsKey(seal)) {
                map.put(seal, map.get(seal) + 1);
            }
        }

        int min = map.entrySet().stream()
                .map(entry -> {
                    char key = entry.getKey();
                    int value = entry.getValue();
                    return (key == 'R' || key == 'E') ? value / 2 : value;
                })
                .min(Integer::compareTo)
                .get();

        bw.write(String.valueOf(min));
        br.close();
        bw.close();
    }
}
