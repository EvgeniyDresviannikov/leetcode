package graphbfs;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation {

    int result = Integer.MAX_VALUE;
    String[] genes;


    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT",
                "AAACGGTA",
                new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

       genes = bank;

        for (int i = 0; i < bank.length; i++) {
            if (isValidForNextMutation(startGene, bank[i])) {
                Set<String> visited = new HashSet<>();
                visited.add(bank[i]);
                dfs(bank[i], endGene, 1, visited);
                visited.remove(bank[i]);
            }
        }

       return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(String currentGene, String endGene, int level, Set<String> visited) {
        if (currentGene.equals(endGene)) {
            result = Math.min(result, level);
            return;
        }

        for (int i = 0; i < genes.length; i++) {
            String gene = genes[i];
            if (!visited.contains(gene) && isValidForNextMutation(currentGene, gene)) {
                visited.add(gene);
                dfs(gene, endGene, level+1, visited);
                visited.remove(gene);
            }
        }

    }

    private boolean isValidForNextMutation(String current, String proposed) {
        int counter = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != proposed.charAt(i)) {
                counter++;
            }
        }

        return counter == 1;
    }


}
