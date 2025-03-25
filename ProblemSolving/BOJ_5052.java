import java.io.*;
import java.util.*;

public class BOJ_5052 {
    static class TrieNode{
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminalNode;

        TrieNode(){
        }

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);

                if (i == word.length() - 1) {
                    trieNode.terminalNode = true;
                    return;
                }
            }
        }

        public boolean contains(String word) {
            TrieNode trieNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);

                if (node == null) {
                    return false;
                }

                trieNode = node;
            }

            return !trieNode.terminalNode || !trieNode.childNode.isEmpty();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            TrieNode trie = new TrieNode();
            List<String> keyList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String key = br.readLine();
                trie.insert(key);
                keyList.add(key);
            }

            boolean isValid = true;
            for (String key : keyList) {
                if (trie.contains(key)) {
                    isValid = false;
                    break;
                }
            }
            sb.append(isValid ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
