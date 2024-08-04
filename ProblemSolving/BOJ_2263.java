import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2263 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] inorder = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		int[] postorder = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] inorderIdx = new int [N + 1];
		for(int i = 0; i < N; i++) {
			inorderIdx[inorder[i]] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		findPreorder(0, N - 1, 0, N - 1, sb, inorder, postorder, inorderIdx);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static void findPreorder(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight, StringBuilder sb, int[] inorder, int[] postorder, int[] inorderIdx) {
		if (inorderRight < inorderLeft || postorderRight < postorderLeft) {
			return;
		}
		
		int root = postorder[postorderRight];
		int rootIdx = inorderIdx[root];
		sb.append(root + " ");
		
		int len = rootIdx - inorderLeft;
		findPreorder(inorderLeft, rootIdx - 1, postorderLeft, postorderLeft + len - 1, sb, inorder, postorder, inorderIdx);
		findPreorder(rootIdx + 1, inorderRight, postorderLeft + len, postorderRight - 1, sb, inorder, postorder, inorderIdx);
	}
}
