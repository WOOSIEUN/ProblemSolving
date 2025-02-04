import java.io.*;
import java.util.*;

public class BOJ_1325 {

    static List<Integer>[] computers;
    static int[] numOfHackedComputers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N];
        numOfHackedComputers = new int[N];

        for (int i = 0; i < N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            computers[start].add(end);
        }

        for (int cur = 0; cur < N; cur++) {
            hackComputers(cur);
        }

        int max = Arrays.stream(numOfHackedComputers).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfHackedComputers.length; i++) {
            if (numOfHackedComputers[i] == max) {
                sb.append(i + 1).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        br.close();
        bw.close();
    }

    private static void hackComputers(int start) {
        boolean[] visited = new boolean[computers.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : computers[cur]) {
                if (visited[next]) {
                    continue;
                }

                queue.add(next);
                visited[next] = true;
                numOfHackedComputers[next]++;
            }
        }
    }
}
