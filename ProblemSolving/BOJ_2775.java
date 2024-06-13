import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int T = Integer.parseInt(br.readLine());
		int[][] input = new int [T][2];	
		int maxFloor = 0, maxRoom = 0;
		
		for (int t = 0; t < T; t++) {
			input[t][0] = Integer.parseInt(br.readLine());
			input[t][1] = Integer.parseInt(br.readLine());
			maxFloor = Math.max(maxFloor, input[t][0]);
			maxRoom = Math.max(maxRoom, input[t][1]);			
		}
		
		int[][] apartment = new int [maxFloor + 1][maxRoom + 1];
		
		for (int room = 1; room <= maxRoom; room++) {
			apartment[0][room] = room;
		}
		
		for (int floor = 1; floor <= maxFloor; floor++) {
			for (int room = 1; room <= maxRoom; room++) {
				int sum = 0;
				for (int prev = 1; prev <= room; prev++) {
					sum += apartment[floor - 1][prev];
				}
				
				apartment[floor][room] = sum;;
			}
		}
		
		StringBuilder sb = new StringBuilder();	
		for (int t = 0; t < T; t++) {
			sb.append(apartment[input[t][0]][input[t][1]]).append("\n");
		}	
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}