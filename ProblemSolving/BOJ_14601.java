import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14601 {
	static int K, size, X, Y, tile;
	static int[][] floor;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		size = 1 << K;
		
		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken()) - 1;
		X = size - Integer.parseInt(st.nextToken());
		floor = new int[size][size];
		floor[X][Y] = -1;
		
		divideFloor(0, 0, size);
		bw.write(printFloor());		
		br.close();
		bw.close();
	}

	private static void divideFloor(int x, int y, int len) {
		int half = len / 2;
		tile += 1;
		
		if(!hasDrain(x, y, half)) {
			floor[x + half - 1][y + half - 1] = tile;
		}
		if(!hasDrain(x, y + half, half)) {
			floor[x + half - 1][y + half] = tile;
		}
		if(!hasDrain(x + half, y, half)) {
			floor[x + half][y + half - 1] = tile;
		}
		if(!hasDrain(x + half, y + half, half)) {
			floor[x + half][y + half] = tile;
		}

		if(len == 2) {
			return;
		}
		
		divideFloor(x, y, half);
		divideFloor(x, y + half, half);
		divideFloor(x + half, y, half);
		divideFloor(x + half, y + half, half);
	}

	private static boolean hasDrain(int x, int y, int len) {
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (floor[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static String printFloor() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(floor[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
