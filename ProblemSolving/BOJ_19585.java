import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19585 {
    static class TrieNode {
        TrieNode[] childNode;
        boolean terminalNode;

        TrieNode() {
            childNode = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (trieNode.childNode[c - 'a'] == null) {
                    trieNode.childNode[c - 'a'] = new TrieNode();
                }
                trieNode = trieNode.childNode[c - 'a'];

                if (i == word.length() - 1) {
                    trieNode.terminalNode = true;
                    return;
                }
            }
        }

        public boolean isValid(String word, Set<String> nameSet) {
            TrieNode trieNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode[c - 'a'];

                if (node == null) {
                    return false;
                }

                if (node.terminalNode && nameSet.contains(word.substring(i + 1))) {
                    return true;
                }

                trieNode = node;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        TrieNode trie = new TrieNode();
        for (int i = 0; i < C; i++) {
            trie.insert(br.readLine());
        }

        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nameSet.add(br.readLine());
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++){
            sb.append(trie.isValid(br.readLine(), nameSet) ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
