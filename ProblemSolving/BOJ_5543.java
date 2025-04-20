import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_5543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] burgers = new int [3];
		for (int i = 0; i < burgers.length; i++) {
			burgers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(burgers);
		
		int[] drinks = new int [2];
		for (int i = 0; i < drinks.length; i++) {
			drinks[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(drinks);
		
		bw.write(String.valueOf(burgers[0] + drinks[0] - 50));
		br.close();
		bw.close();
	}
}
