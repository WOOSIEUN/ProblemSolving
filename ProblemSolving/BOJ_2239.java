import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2239 {
	static int[][] map = new int [9][9];
	static boolean[][] row = new boolean[9][10], col = new boolean[9][10], square = new boolean[9][10];
	static String line;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 9; i++)	{
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
				if(map[i][j] != 0) setSudoku(i, j, map[i][j], true);
			}
		}
		sudoku(0);		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void setSudoku(int x, int y, int value, boolean TorF) {
		row[x][value] = TorF;
		col[y][value] = TorF;
		square[(x / 3) * 3 + (y / 3)][value] = TorF;
	}

	private static void sudoku(int depth) {
		int x = depth / 9;
		int y = depth % 9;
		if(depth == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(map[i][j] + "");
				sb.append("\n");
			}
			flag = true;
			return;
		}
		if(map[x][y] == 0) {
			for (int i = 1; i <= 9; i++)
				if (!row[x][i] && !col[y][i] && !square[(x / 3) * 3 + (y / 3)][i]) {
					map[x][y] = i;
					setSudoku(x, y, i, true);
					sudoku(depth + 1);
					if(flag) return;
					map[x][y] = 0;
					setSudoku(x, y, i, false);
				}
		} else {
			sudoku(depth+1);
		}
	}
}

