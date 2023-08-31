import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1019 {
	
	static int[] count = new int [10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int left = 1, right = N, digit = 1;
		while (left <= right) {
			while (right % 10 != 9 && left <= right) {
				count(right, digit);
				right--;
			}			

            if (right < left) {
                break;
            }
			
			while (left % 10 != 0 && left <= right) {
				count(left, digit);
	            left++;
	        }
	            
			left /= 10;
            right /= 10;    

            for (int i = 0; i < 10; i++) {
            	count[i] += (right - left + 1) * digit;
            }

            digit *= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		Arrays.stream(count).forEach(i -> sb.append(i).append(" "));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static void count(int num, int digit) {
		 while (num > 0) {
	     	count[num % 10] += digit;
	     	num /= 10;
		 }
	}
}
