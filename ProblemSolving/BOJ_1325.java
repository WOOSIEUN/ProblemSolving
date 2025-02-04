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

        computers = new ArrayList[N + 1];
        numOfHackedComputers = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            computers[start].add(end);
        }

        for (int start = 1; start < N + 1; start++) {
            if (computers[start].isEmpty()) {
                continue;
            }

            boolean[] visited = new boolean[computers.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : computers[cur]) {
                    if (visited[next]) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                    numOfHackedComputers[next]++;
                }
            }
        }

        int max = 0;
        for (int cnt : numOfHackedComputers) {
            if (cnt > max) {
                max = cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numOfHackedComputers.length; i++) {
            if (numOfHackedComputers[i] == max) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
