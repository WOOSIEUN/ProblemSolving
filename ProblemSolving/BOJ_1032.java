import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		char[][] files = new char [N][0];
		for (int i = 0; i < N; i++) {
			files[i] = br.readLine().toCharArray();
		}
		
		StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < files[0].length; i++) {
	    	boolean same = true;
	    	char ch = files[0][i];
	        for (int j = 1; j < N; j++) {
	        	if (ch != files[j][i]) {
	        		same = false;
	        		break;
	            }
	        }
	        
	        sb.append(same ? ch : "?");
	    }
	    
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
