import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int laptopWidth = Integer.parseInt(st.nextToken());
		int laptopHeight = Integer.parseInt(st.nextToken());
		int stickerWidth = Integer.parseInt(st.nextToken());
		int stickerHeight = Integer.parseInt(st.nextToken());
		
		bw.write(stickerWidth <= laptopWidth - 2 && stickerHeight <= laptopHeight - 2 ? "1" : "0");
		br.close();
		bw.close();
	}
}
