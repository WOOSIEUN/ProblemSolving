import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20125 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] cookie = new char [N][N];
		
		for (int i = 0; i < N; i++) {
			cookie[i] = br.readLine().toCharArray();
		}
		
		int heartX = -1, heartY = -1;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (cookie[i][j] == '*' && cookie[i + 1][j] == '*' && cookie[i - 1][j] == '*' && cookie[i][j + 1] == '*' && cookie[i][j - 1] == '*') {
					heartX = i;
					heartY = j;
					break;
				}
			}
		}
		
		int leftArm = 0;
		for (int y = heartY - 1; y >= 0; y--) {
			if (cookie[heartX][y] != '*') {
				break;
			}
			leftArm++;
		}

		int rightArm = 0;
		for (int y = heartY + 1; y < N; y++) {
			if (cookie[heartX][y] != '*') {
				break;
			}
			rightArm++;
		}
		
		int waist = 0, waistEndX = -1;
		for (int x = heartX + 1; x < N; x++) {
			if (cookie[x][heartY] != '*') {
				waistEndX = x;
				break;
			}
			waist++;
		}
		
		int leftLeg = 0;
		for (int x = waistEndX; x < N; x++) {
			if (cookie[x][heartY - 1] != '*') {
				break;
			}
			leftLeg++;
		}
		
		int rightLeg = 0;
		for (int x = waistEndX; x < N; x++) {
			if (cookie[x][heartY + 1] != '*') {
				break;
			}
			rightLeg++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(heartX + 1).append(" ").append(heartY + 1).append("\n");
		sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
