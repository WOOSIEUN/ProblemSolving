import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2448 {
	static char[][] map;
	static char[][] star = { "  *  ".toCharArray(), " * * ".toCharArray(), "*****".toCharArray() };
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char [N][N*2-1];
		printStar(0,0,N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N*2-1; j++)
				if(map[i][j] == '*') sb.append('*');
				else sb.append(" ");				
			sb.append("\n");
		}
			
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void printStar(int x, int y, int n) {
		if (n == 3) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++)
					map[x+i][y+j] = star[i][j];
			return;				
		}
		printStar(x, y + n / 2, n / 2);
		printStar(x + n / 2, y, n / 2);
		printStar(x + n / 2, y + n, n / 2);
	}
}