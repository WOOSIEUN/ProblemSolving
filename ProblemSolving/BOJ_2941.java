import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2941 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String croatianAlphbet[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = br.readLine();
		for (int i = 0; i < croatianAlphbet.length; i++) {
			if (str.contains(croatianAlphbet[i])) {
				str = str.replace(croatianAlphbet[i], ".");
			}
		}
		
		bw.write(String.valueOf(str.length()));
		br.close();
		bw.close();
	}
}
