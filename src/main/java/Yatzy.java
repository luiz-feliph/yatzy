import java.util.*;

public class Yatzy {

    public Yatzy() {
    }

    public int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
        return differentFaces.size() == 1? 50 : 0;
    }

    public int sumDiceWithFace(int face, int d1, int d2, int d3, int d4, int d5) {
        int[] fiveDiceResults = {d1, d2, d3, d4, d5};
        int score = 0;
        for (int result : fiveDiceResults) {
            if (result == face) score += result;
        }
        return score;
    }

    public int pair(int d1, int d2, int d3, int d4, int d5) {
        ArrayList<Integer> fiveDiceResults = new ArrayList<>(List.of(d1, d2, d3, d4, d5));
        fiveDiceResults.sort(Collections.reverseOrder());
        Set<Integer> differentFaces = new LinkedHashSet<>(fiveDiceResults);

        for (Integer face : differentFaces) {
            int count = 0;
            for (Integer result : fiveDiceResults) {
                if (result == face) count++;
                if (count == 2) return face * 2;
            }
        }

        return 0;
    }

    public int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        Integer[] fiveDiceResults = {d1, d2, d3, d4, d5};
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(fiveDiceResults));
        int score = 0, countPairs = 0;

        for (int face : differentFaces) {
            int countFaces = 0;

            for (int result : fiveDiceResults) {
                if (result == face) countFaces++;
                if (countFaces == 2) {
                    score += face * 2;
                    countPairs++;
                    break;
                }
            }
        }
        if (countPairs != 2) return 0;

        return score;
    }

    public int nOfAKind(int requiredCount, int d1, int d2, int d3, int d4, int d5) {
        Integer[] fiveDiceResults = {d1, d2, d3, d4, d5};
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(fiveDiceResults));

        for (int face : differentFaces) {
            int countFaces = 0;
            for (int result : fiveDiceResults) {
                if (result == face) countFaces++;
                if (countFaces == requiredCount) return face * requiredCount;
            }
        }

        return 0;
    }

    public int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
        if (differentFaces.size() == 5 && !differentFaces.contains(6))
            return differentFaces.stream().reduce(0, Integer::sum);

        return 0;
    }

    public int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
        if (differentFaces.size() == 5 && !differentFaces.contains(1))
            return differentFaces.stream().reduce(0, Integer::sum);

        return 0;
    }

    public int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        Set<Integer> differentFaces = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
        if (differentFaces.size() == 2) {
            boolean is_there_three_of_a_kind = nOfAKind(3, d1, d2, d3, d4, d5) != 0;
            if (is_there_three_of_a_kind) return d1 + d2 + d3 + d4 + d5;
        }

        return 0;
    }
}
