import java.io.*;
import java.util.*;

public class BOJ_5670 {
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

        public int typeWord(String word) {
            TrieNode trieNode = this;

            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);

                if (i == 0 || trieNode.terminalNode || trieNode.childNode.size() > 1) {
                    cnt++;
                }

                trieNode = node;
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);

            TrieNode trie = new TrieNode();
            List<String> wordsList = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String key = br.readLine();
                trie.insert(key);
                wordsList.add(key);
            }

            double res = 0;
            for (String word : wordsList) {
                res += trie.typeWord(word);
            }

            sb.append(String.format("%.2f", res / wordsList.size())).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
