import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] figure = new int [N + 2][M + 2];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				figure[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int surfaceArea = N * M * 2;
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				for (int[] dir : dirs) {
					int nx = i + dir[0];
					int ny = j + dir[1];
					if (figure[nx][ny] < figure[i][j]) {
						surfaceArea += (figure[i][j] - figure[nx][ny]);
					}
				}
			}
		}
		
		bw.write(String.valueOf(surfaceArea));
		br.close();
		bw.close();
	}
}
