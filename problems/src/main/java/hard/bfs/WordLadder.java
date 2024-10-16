package hard.bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("red", "tax", List.of("ted","tex","red","tax","tad","den","rex","pee")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);
        queue.add(beginWord);

        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String pop = queue.poll();

                if (pop.equals(endWord)) {
                    return res;
                }

                for (int j = 0; j < pop.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = pop.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if (wordSet.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }

            ++res;

        }

        return 0;
    }

}
