import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_13144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(arr[i])) {
                for (int j = start; j < i; j++){
                    result += i - j;
                    start++;
                    
                    if (arr[j] == arr[i]) {
                        break;
                    }
                    
                    set.remove(arr[j]);
                }
            } else {
                set.add(arr[i]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            result += N - i;
        }
        
		bw.write(String.valueOf(result));
		br.close();
		bw.close();
	}
}
