import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private final Yatzy yatzy = new Yatzy();

    // Chance category
    @Test
    public void chance_returns_14_given_1_1_3_3_6() {
        assertEquals(14, yatzy.chance(1,1,3,3,6));
    }

    @Test
    public void chance_returns_21_given_4_5_5_6_1() {
        assertEquals(21, yatzy.chance(4,5,5,6,1));
    }

    // Yatzy category
    @Test
    public void yatzy_returns_50_given_1_1_1_1_1() {
        assertEquals(50, yatzy.yatzy(1,1,1,1,1));
    }

    @Test
    public void yatzy_returns_0_given_1_1_1_2_1() {
        assertEquals(50, yatzy.yatzy(1,1,1,1,1));
    }

    // Ones category
    @Test
    public void ones_returns_3_given_1_2_1_6_1() {
        int face = 1;
        assertEquals(3, yatzy.sumDiceWithFace(face, 1,2,1,6,1));
    }

    @Test
    public void ones_returns_0_given_3_3_3_4_5() {
        int face = 1;
        assertEquals(0, yatzy.sumDiceWithFace(face, 3,3,3,4,5));
    }

    // Twos category
    @Test
    public void twos_returns_8_given_2_2_1_2_2() {
        int face = 2;
        assertEquals(8, yatzy.sumDiceWithFace(face, 2,2,1,2,2));
    }

    @Test
    public void twos_returns_0_given_1_3_6_4_5() {
        int face = 2;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1,3,6,4,5));
    }

    // Threes category
    @Test
    public void threes_returns_6_given_2_3_1_3_2() {
        int face = 3;
        assertEquals(6, yatzy.sumDiceWithFace(face, 2,3,1,3,2));
    }

    @Test
    public void threes_returns_0_given_1_5_2_4_1() {
        int face = 3;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1,5,2,4,1));
    }

    // Fours category
    @Test
    public void fours_returns_4_given_4_3_5_6_2() {
        int face = 4;
        assertEquals(4, yatzy.sumDiceWithFace(face, 4,3,5,6,2));
    }

    @Test
    public void fours_returns_0_given_6_5_2_3_3() {
        int face = 4;
        assertEquals(0, yatzy.sumDiceWithFace(face, 6,5,2,3,3));
    }

    // Fives category
    @Test
    public void fives_returns_20_given_4_5_5_5_5() {
        int face = 5;
        assertEquals(20, yatzy.sumDiceWithFace(face, 4,5,5,5,5));
    }

    @Test
    public void fives_returns_0_given_1_1_2_3_3() {
        int face = 5;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1,1,2,3,3));
    }

    // Sixes category
    @Test
    public void sixes_returns_6_given_6_1_2_4_5() {
        int face = 6;
        assertEquals(6, yatzy.sumDiceWithFace(face, 6,1,2,4,5));
    }

    @Test
    public void sixes_returns_0_given_4_1_2_5_3() {
        int face = 6;
        assertEquals(0, yatzy.sumDiceWithFace(face, 4,1,2,5,3));
    }

    // Pair category
    @Test
    public void pair_returns_0_given_1_2_3_4_5() {
        assertEquals(0, yatzy.pair(1,2,3,4,5));
    }

    @Test
    public void pair_returns_8_given_3_3_3_4_4() {
        assertEquals(8, yatzy.pair(3,3,3,4,4));
    }

    @Test
    public void pair_returns_12_given_1_1_6_2_6() {
        assertEquals(12, yatzy.pair(1,1,6,2,6));
    }

    @Test
    public void pair_returns_6_given_3_3_3_4_1() {
        assertEquals(6, yatzy.pair(3,3,3,4,1));
    }

    @Test
    public void pair_returns_6_given_3_3_3_3_1() {
        assertEquals(6, yatzy.pair(3,3,3,3,1));
    }

    // Two pairs category
    @Test
    public void two_pairs_returns_8_given_1_1_2_3_3() {
        assertEquals(9, yatzy.twoPairs(1,1,2,3,3));
    }

    @Test
    public void two_pairs_returns_0_given_1_1_2_3_4() {
        assertEquals(0, yatzy.twoPairs(1,1,2,3,4));
    }
}
