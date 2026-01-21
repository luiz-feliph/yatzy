import java.util.*;

public class Yatzy {

    private int d1, d2, d3, d4, d5;

    public Yatzy() {
    }

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }

    public int getD4() {
        return d4;
    }

    public void setD4(int d4) {
        this.d4 = d4;
    }

    public int getD5() {
        return d5;
    }

    public void setD5(int d5) {
        this.d5 = d5;
    }

    public int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public int yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] fiveDiceResults = {d1, d2, d3, d4, d5};
        for (int i = 1; i < 5; i++) {
            if (fiveDiceResults[i] != fiveDiceResults[i - 1]) return 0;
        }
        return 50;
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
        Set<Integer> DifferentFaces = new LinkedHashSet<>(fiveDiceResults);

        for (Integer face : DifferentFaces) {
            int count = 0;
            for (Integer result : fiveDiceResults) {
                if (result == face) count++;
            }
            if (count == 2) return face * 2;
        }

        return 0;
    }
}
