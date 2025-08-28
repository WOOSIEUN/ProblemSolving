import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_5624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        set.add(arr[0] + arr[0]);

        int ans = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(arr[i] - arr[j])) {
                    ans++;
                    break;
                }
            }

            for (int j = 0; j <= i; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
