import java.io.*;
import java.util.*;

public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> bookMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(bookMap.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (bookMap.get(o2) == bookMap.get(o1)) {
                    return o1.compareTo(o2);
                }
                return bookMap.get(o2).compareTo(bookMap.get(o1));
            }
        });

        bw.write(String.valueOf(keySet.get(0)));
        br.close();
        bw.close();
    }
}
