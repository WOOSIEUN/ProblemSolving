import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992 {
	static StringBuilder sb;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) 
				map[i][j] = tmp.charAt(j)-'0';
		}
		sb = new StringBuilder();
		QuadTree(0, 0, N);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void QuadTree(int i, int j, int N) {
		if(isCompress(i, j, N)) {
			sb.append(map[i][j]);
			return;
		}
		sb.append("(");
		QuadTree(i, j, N/2);
		QuadTree(i, j + N/2, N/2);
		QuadTree(i + N/2, j, N/2);
		QuadTree(i + N/2, j + N/2, N/2);
		sb.append(")");
	}

	private static boolean isCompress(int i, int j, int N) {
		int num = map[i][j];
		boolean isSame = true;
		for (int x = i; x < i+N; x++)
			for (int y = j; y < j+N; y++) 
				if(map[x][y] != num) {
					isSame = false;
					break;
				}
		return isSame;
		}
}
