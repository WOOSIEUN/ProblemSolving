import java.io.*;
import java.util.*;

public class BOJ_14725 {
    static class TrieNode {
    Map<String, TrieNode> childNode = new HashMap<>();

    TrieNode() {
    }

    public void insert(String words) {
        TrieNode trieNode = this;
        StringTokenizer st = new StringTokenizer(words, ",");

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            trieNode.childNode.putIfAbsent(word, new TrieNode());
            trieNode = trieNode.childNode.get(word);
        }
    }

    public String print(TrieNode cur, int depth) {
        StringBuilder sb = new StringBuilder();

        if (cur.childNode != null) {
            List<String> list = new ArrayList<>(cur.childNode.keySet());
            Collections.sort(list);

            for (String str : list) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }

                sb.append(str).append("\n");
                sb.append(print(cur.childNode.get(str), depth + 1));
            }
        }
        return sb.toString();
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TrieNode trie = new TrieNode();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int j = 1; j < K + 1; j++) {
                sb.append(st.nextToken()).append(",");
            }
            trie.insert(sb.toString());
        }

        bw.write(trie.print(trie, 0));
        br.close();
        bw.close();
    }
}
