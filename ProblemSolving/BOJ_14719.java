import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14719 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] blocks = new int [W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = blocks.length - 1;
		int maxHeightOfLeft = blocks[left], maxHeightOfRight = blocks[right];
		while (left < right) {
			maxHeightOfLeft = Math.max(maxHeightOfLeft, blocks[left]);
			maxHeightOfRight = Math.max(maxHeightOfRight, blocks[right]);
			
			if (maxHeightOfLeft > maxHeightOfRight) {
				ans += maxHeightOfRight - blocks[right--];
			} else {
				ans += maxHeightOfLeft - blocks[left++];
			}			
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
