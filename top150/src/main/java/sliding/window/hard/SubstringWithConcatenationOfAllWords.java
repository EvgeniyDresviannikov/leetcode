package sliding.window.hard;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        System.out.println(substringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        Queue<String> usedWords = new ArrayDeque<>();

        Map<String, Integer> remainedWords = new HashMap<>();
        for (String word : words) {
            remainedWords.put(word, remainedWords.getOrDefault(word, 0) + 1);
        }

        int idx = 0;
        int start = 0;
        while (idx <= s.length() - wordLen) {
            String str = s.substring(idx, idx + wordLen);
            if (remainedWords.containsKey(str) && remainedWords.get(str) > 0) {
                remainedWords.put(str, remainedWords.get(str) - 1);
                usedWords.add(str);
                if (usedWords.size() == words.length) {
                    res.add(start);
                    start += wordLen;
                    String pop = usedWords.poll();
                    remainedWords.put(pop, remainedWords.get(pop) + 1);
                }
                idx += wordLen;
            } else {
                if (usedWords.isEmpty()) {
                    idx++;
                    start = idx;
                } else {
                    while (!usedWords.isEmpty()) {
                        String pop = usedWords.poll();
                        remainedWords.put(pop, remainedWords.get(pop) + 1);
                        start += wordLen;
                        if (pop.equals(str)) {
                            break;
                        }
                    }
                    if (usedWords.isEmpty()) start = idx;
                }

            }
        }


        return res;

    }
}
