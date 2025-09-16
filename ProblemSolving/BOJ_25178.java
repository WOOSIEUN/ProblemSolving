import java.io.*;

public class BOJ_25178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        bw.write(isDuramuri(br.readLine().toCharArray(), br.readLine().toCharArray()) ? "YES" : "NO");
        br.close();
        bw.close();
    }

    private static boolean isDuramuri(char[] word1, char[] word2) {
        if (word1[0] != word2[0] || word1[word1.length - 1] != word2[word2.length - 1]) {
            return false;
        }
        
        StringBuilder word1RemoveVowels = new StringBuilder();
        StringBuilder word2RemoveVowels = new StringBuilder();
        int[] word1Alphabet = new int[26];
        int[] word2Alphabet = new int[26];
        
        for (int i = 0; i < word1.length; i++) {
            if (!isVowel(word1[i])) {
                word1RemoveVowels.append(word1[i]);
            }
            if (!isVowel(word2[i])) {
                word2RemoveVowels.append(word2[i]);
            }
            word1Alphabet[word1[i] - 'a']++;
            word2Alphabet[word2[i] - 'a']++;
        }
        
        return word1RemoveVowels.toString().equals(word2RemoveVowels.toString()) && isSame(word1Alphabet, word2Alphabet);
    }

    private static boolean isSame(int[] word1Alpabet, int[] word2Alpabet) {
        for (int i = 0; i < word1Alpabet.length; i++) {
            if (word1Alpabet[i] != word2Alpabet[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
