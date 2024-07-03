import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] M = br.readLine().toCharArray();
		
		int third = (M[2] - '0') * N;
		int fourth = (M[1] - '0') * N; 
		int fifth = (M[0] - '0') * N;
		int sixth = fifth * 100 + fourth * 10 + third;
		
		StringBuilder sb = new StringBuilder();
		sb.append(third).append("\n").append(fourth).append("\n").append(fifth).append("\n").append(sixth).append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
