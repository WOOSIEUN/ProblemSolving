import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2630 {
	
	static int numOfBlue, numOfWhite;
	static boolean[][] coloredPaper;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		coloredPaper = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					coloredPaper[i][j] = true;
				}
			}
		}
		
		divideColoredPaper(0, 0, N);
		
		bw.write(numOfWhite + "\n" + numOfBlue);
		br.close();
		bw.close();
	}

	private static void divideColoredPaper(int x, int y, int length) {
		if (isSameColor(x, y, length)) {
			if (coloredPaper[x][y]) {
				numOfBlue++;
			} else {
				numOfWhite++;
			}		
			return;
		}
		
		int dividedLength = length / 2;
		divideColoredPaper(x, y, dividedLength);
		divideColoredPaper(x, y + dividedLength, dividedLength);
		divideColoredPaper(x + dividedLength, y, dividedLength);
		divideColoredPaper(x + dividedLength, y + dividedLength, dividedLength);
	}

	private static boolean isSameColor(int x, int y, int length) {
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				if (coloredPaper[x][y] != coloredPaper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
