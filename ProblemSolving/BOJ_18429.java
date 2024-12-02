import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18429 {

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] equipments = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            equipments[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        ans = 0;
        findNumOfStrengthsOver500(500, 0, N, K, equipments, visited);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static void findNumOfStrengthsOver500(int strength, int depth, int N, int K, int[] equipments, boolean[] visited) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (strength - K + equipments[i]) >= 500) {
                visited[i] = true;
                findNumOfStrengthsOver500(strength - K + equipments[i], depth + 1, N, K, equipments, visited);
                visited[i] = false;
            }
        }
    }
}
