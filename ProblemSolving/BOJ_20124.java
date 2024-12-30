import java.io.*;
import java.util.*;

public class BOJ_20124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> students = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        List<String> keySet = new ArrayList<>(students.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (students.get(o1) == students.get(o2)) {
                    return o1.compareTo(o2);
                }
                return students.get(o2).compareTo(students.get(o1));
            }
        });

        bw.write(keySet.get(0));
        br.close();
        bw.close();
    }
}
