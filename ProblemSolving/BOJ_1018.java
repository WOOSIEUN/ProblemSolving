import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1018 {

    static final int LEN = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = (row[j] == 'B');
            }
        }

        int ans = LEN * LEN;
        for (int startX = 0; startX < board.length - LEN + 1; startX++) {
            for (int startY = 0; startY < board[0].length - LEN + 1; startY++) {
                ans = Math.min(ans, countColorChange(startX, startY, board));
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static int countColorChange(int startX, int startY, boolean[][] board) {
        boolean curCell = board[startX][startY];
        int count = 0;
        for (int x = startX; x < startX + LEN; x++) {
            for (int y = startY; y < startY + LEN; y++) {
                if (board[x][y] != curCell) {
                    count++;
                }
                curCell = !curCell;
            }
            curCell = !curCell;
        }
        return Math.min(count, LEN * LEN - count);
    }
}
