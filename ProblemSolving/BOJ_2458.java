import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] relations = new boolean[N + 1][N + 1];
        boolean[][] reversedRelations = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a][b] = true;
            reversedRelations[b][a] = true;
        }

        for (int i = 1; i < relations.length; i++) {
            relations[i][i] = true;
            reversedRelations[i][i] = true;
        }

        relations = floydWarshall(relations);
        reversedRelations = floydWarshall(reversedRelations);

        int ans = 0;
        for (int i = 1; i < relations.length; i++) {
            boolean comparable = true;
            for (int j = 1; j < relations.length; j++) {
                if (!relations[i][j] && !reversedRelations[i][j]) {
                    comparable = false;
                    break;
                }
            }

            if (comparable) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean[][] floydWarshall(boolean[][] relations) {
        for (int k = 1; k < relations.length; k++) {
            for (int i = 1; i < relations.length; i++) {
                for (int j = 1; j < relations.length; j++) {
                    if (relations[i][k] && relations[k][j]) {
                        relations[i][j] = true;
                    }
                }
            }
        }
        return relations;
    }
}
