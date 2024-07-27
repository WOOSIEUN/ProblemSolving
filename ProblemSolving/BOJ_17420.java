import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17420 {
	static class Gifticon implements Comparable<Gifticon> {
		int remainDay, useDay;
		
		public Gifticon(int remainDay, int useDay) {
			this.remainDay = remainDay;
			this.useDay = useDay;
		}
		
		@Override
		public int compareTo(Gifticon gifticon) {
			if (this.useDay == gifticon.useDay) {
				return this.remainDay - gifticon.remainDay;
			}
			return this.useDay - gifticon.useDay;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Gifticon[] gifticons = new Gifticon [N];
		
		StringTokenizer aSt = new StringTokenizer(br.readLine());
		StringTokenizer bSt = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gifticons[i] = new Gifticon(Integer.parseInt(aSt.nextToken()), Integer.parseInt(bSt.nextToken()));
		}
		
		Arrays.sort(gifticons);
		
		long ans = 0;
		int prevMax = gifticons[0].useDay, curMax = -1;
		for (int i = 0; i < N; i++) {
			if (prevMax > gifticons[i].remainDay) {
				prevMax = Math.max(prevMax, gifticons[i].useDay);
				int extensionCnt = (prevMax - gifticons[i].remainDay + 29) / 30;
				gifticons[i].remainDay += extensionCnt * 30;
				ans += extensionCnt;
			}
			
			curMax = Math.max(curMax, gifticons[i].remainDay);
			
			if (i + 1 < N && gifticons[i].useDay != gifticons[i + 1].useDay) {
				prevMax = curMax;
			}
		}		
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
