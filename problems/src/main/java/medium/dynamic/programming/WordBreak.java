package medium.dynamic.programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }

    public  boolean wordBreak (String s, List<String> wordDict ) {
        Map<String, Boolean> dp = new HashMap<>();
        return dfs(s, wordDict, dp);
    }

    private boolean dfs(String currentWord, List<String> wordDict, Map<String, Boolean> dp) {
        if (currentWord.isEmpty()) return true;
        if (dp.containsKey(currentWord)) return dp.get(currentWord);

        for (String str : wordDict) {
            if (currentWord.startsWith(str)) {
                boolean res = dfs(currentWord.substring(str.length()), wordDict, dp);
                dp.put(currentWord, res);
                if (res) return true;
            }
        }

        return false;
    }
}
