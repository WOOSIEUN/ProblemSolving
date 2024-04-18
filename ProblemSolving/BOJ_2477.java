import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		int[][] field = new int [6][2];
		int[] count = new int [4];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			field[i][0] = Integer.parseInt(st.nextToken()) - 1;
			field[i][1] = Integer.parseInt(st.nextToken());
			count[field[i][0]]++;
		}
		
		int biggerArea = 1, smallerArea = 1;		
		for (int i = 0; i < 6; i++) {
	        if (count[field[i][0]] == 1) {
	        	biggerArea *= field[i][1];
	            continue;
	        }

	        int next = (i + 1) % 6;
	        int secondNext = (i + 2) % 6;
	        
	        if (field[i][0] == field[secondNext][0]) {
	        	smallerArea *= field[next][1];
	        }
	    }
		
		bw.write(String.valueOf((biggerArea - smallerArea) * K));
		br.close();
		bw.close();
	}
}
