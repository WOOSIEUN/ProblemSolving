import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<String> ingredients = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ingredients.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            ingredients.remove(st.nextToken());
        }

        bw.write(String.valueOf(ingredients.toArray()[0]));
        br.close();
        bw.close();
    }
}
