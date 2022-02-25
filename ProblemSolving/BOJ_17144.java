import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int [] airPurifier = new int [2];
	static int [][] map, dust;
	static int R, C, T, result, nx, ny, cntPuri, quantity, cntSpread;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int [R][C];
        dust = new int [R][C];     
        for(int i = 0 ; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) airPurifier[cntPuri++] = i;
			}
        }
       
        for (int i = 0; i < T; i++) {
            dustSpread();
            purifyDust();
        }
        
        bw.write("" + cntDust());
        bw.close();
        br.close();
	}

	public static void dustSpread() {
		copyMap(map, dust);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {	
					cntSpread = 0;
					quantity = map[i][j] / 5;
					for (int[] dir : dirs) {
						nx = i + dir[0];
						ny = j + dir[1];
						if(0 <= nx && nx < R && 0 <= ny && ny < C && map[nx][ny] != -1) {
							dust[nx][ny] += quantity;
							cntSpread++;
						}
					}
					dust[i][j] -= (quantity * cntSpread);
				}
			}
		}
		copyMap(dust, map);
	}
	
	private static void purifyDust() {
		int endR = R - 1;
		int endC = C - 1;
		//upper - clockwise
		for (int i = airPurifier[0] - 1; i > 0; i--) map[i][0] = map[i-1][0];
		for (int i = 0; i < endC; i++) map[0][i] = map[0][i+1];
		for (int i = 0; i < airPurifier[0]; i++) map[i][endC] = map[i+1][endC];
		for (int i = endC; i > 1; i--) map[airPurifier[0]][i] = map[airPurifier[0]][i-1];
		map[airPurifier[0]][1] = 0;
		
		//lower - counterclockwise
		for (int i = airPurifier[1] + 1; i < endR; i++) map[i][0] = map[i+1][0];
		for (int i = 0; i < endC; i++) map[endR][i] = map[endR][i+1];
		for (int i = endR; i > airPurifier[1]; i--) map[i][endC] = map[i-1][endC];
		for (int i = endC; i > 1; i--) map[airPurifier[1]][i] = map[airPurifier[1]][i-1];
		map[airPurifier[1]][1] = 0;
	}
	
	private static int cntDust() {
		int cnt = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if(map[i][j] != -1)
					cnt += map[i][j];
		return cnt;
	}
	
	public static void copyMap(int[][] src, int[][] des) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				des[i][j] = src[i][j];
	}
}