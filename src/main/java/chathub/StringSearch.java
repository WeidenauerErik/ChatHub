package chathub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSearch {

    // Methode zum Berechnen des Levenshtein-Abstands
    public static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[a.length()][b.length()];
    }

    // Methode zum Finden der besten 5 Übereinstimmungen
    public static List<String> findBestMatches(String input, List<String> list) {
        List<String> bestMatches = new ArrayList<>(list);
        Collections.sort(bestMatches, Comparator.comparingInt(s -> levenshteinDistance(input, s)));

        return bestMatches.subList(0, Math.min(5, bestMatches.size()));
    }

    public static void main(String[] args) {
        String input = "Beispieltext";
        List<String> list = List.of("Beispiel", "Test", "Beispieltext", "Beispielhafte Texte", "Probe", "Exempel");

        List<String> bestMatches = new ArrayList<>(list);
        Collections.sort(bestMatches, Comparator.comparingInt(s -> levenshteinDistance(input, s)));

        System.out.println("Die besten 5 Übereinstimmungen sind:");
        for (String match : bestMatches) {
            System.out.println(match);
        }
    }
}
