import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private final Yatzy yatzy = new Yatzy();

    // Chance category
    @Test
    public void chance_returns_sum_of_all_dice_values() {
        assertEquals(14, yatzy.chance(1, 1, 3, 3, 6));
    }

    @Test
    public void chance_also_returns_sum_of_all_dice_values() {
        assertEquals(21, yatzy.chance(4, 5, 5, 6, 1));
    }

    // Yatzy category
    @Test
    public void yatzy_returns_50_when_all_dice_values_are_equals() {
        assertEquals(50, yatzy.yatzy(1, 1, 1, 1, 1));
    }

    @Test
    public void yatzy_returns_0_when_there_is_any_different_value() {
        assertEquals(0, yatzy.yatzy(1, 1, 1, 2, 1));
    }

    // Ones category
    @Test
    public void ones_returns_sum_of_all_dice_with_face_value_one() {
        int face = 1;
        assertEquals(3, yatzy.sumDiceWithFace(face, 1, 2, 1, 6, 1));
    }

    @Test
    public void ones_returns_0_when_there_are_no_dice_with_face_value_one() {
        int face = 1;
        assertEquals(0, yatzy.sumDiceWithFace(face, 3, 3, 3, 4, 5));
    }

    // Twos category
    @Test
    public void twos_returns_sum_of_all_dice_with_face_value_two() {
        int face = 2;
        assertEquals(8, yatzy.sumDiceWithFace(face, 2, 2, 1, 2, 2));
    }

    @Test
    public void twos_returns_0_when_there_are_no_dice_with_face_value_two() {
        int face = 2;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1, 3, 6, 4, 5));
    }

    // Threes category
    @Test
    public void threes_returns_sum_of_all_dice_with_face_value_three() {
        int face = 3;
        assertEquals(6, yatzy.sumDiceWithFace(face, 2, 3, 1, 3, 2));
    }

    @Test
    public void threes_returns_0_when_there_are_no_dice_with_face_value_three() {
        int face = 3;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1, 5, 2, 4, 1));
    }

    // Fours category
    @Test
    public void fours_returns_sum_of_all_dice_with_face_value_four() {
        int face = 4;
        assertEquals(4, yatzy.sumDiceWithFace(face, 4, 3, 5, 6, 2));
    }

    @Test
    public void fours_returns_0_when_there_are_no_dice_with_face_value_four() {
        int face = 4;
        assertEquals(0, yatzy.sumDiceWithFace(face, 6, 5, 2, 3, 3));
    }

    // Fives category
    @Test
    public void fives_returns_sum_of_all_dice_with_face_value_five() {
        int face = 5;
        assertEquals(20, yatzy.sumDiceWithFace(face, 4, 5, 5, 5, 5));
    }

    @Test
    public void fives_returns_0_when_there_are_no_dice_with_face_value_five() {
        int face = 5;
        assertEquals(0, yatzy.sumDiceWithFace(face, 1, 1, 2, 3, 3));
    }

    // Sixes category
    @Test
    public void sixes_returns_sum_of_all_dice_with_face_value_six() {
        int face = 6;
        assertEquals(6, yatzy.sumDiceWithFace(face, 6, 1, 2, 4, 5));
    }

    @Test
    public void sixes_returns_0_when_there_are_no_dice_with_face_value_six() {
        int face = 6;
        assertEquals(0, yatzy.sumDiceWithFace(face, 4, 1, 2, 5, 3));
    }

    // Pair category
    @Test
    public void pair_returns_0_when_there_are_no_pairs() {
        assertEquals(0, yatzy.pair(1, 2, 3, 4, 5));
    }

    @Test
    public void pair_returns_twice_the_highest_pair_value() {
        assertEquals(8, yatzy.pair(3, 3, 3, 4, 4));
    }

    @Test
    public void pair_also_returns_twice_the_highest_pair_value() {
        assertEquals(12, yatzy.pair(1, 1, 6, 2, 6));
    }

    @Test
    public void pair_returns_only_twice_the_highest_pair_value_even_if_there_are_two_same_pairs() {
        assertEquals(6, yatzy.pair(3, 3, 3, 3, 1));
    }

    // Two pairs category
    @Test
    public void two_pairs_returns_sum_of_two_distinct_pairs() {
        assertEquals(8, yatzy.twoPairs(1, 1, 2, 3, 3));
    }

    @Test
    public void two_pairs_returns_0_when_there_is_only_one_pair() {
        assertEquals(0, yatzy.twoPairs(1, 1, 2, 3, 4));
    }

    @Test
    public void two_pairs_returns_sum_of_two_distinct_pairs_even_when_there_is_a_three_of_a_kind() {
        assertEquals(6, yatzy.twoPairs(1, 1, 2, 2, 2));
    }

    @Test
    public void two_pairs_returns_0_when_there_is_a_four_of_a_kind() {
        assertEquals(0, yatzy.twoPairs(3, 3, 3, 3, 1));
    }

    // Three of a kind category
    @Test
    public void three_of_a_kind_returns_sum_of_three_equal_values() {
        int requiredCount = 3;
        assertEquals(9, yatzy.nOfAKind(requiredCount, 3, 3, 3, 4, 5));
    }

    @Test
    public void three_of_a_kind_returns_0_when_there_is_no_three_of_a_kind() {
        int requiredCount = 3;
        assertEquals(0, yatzy.nOfAKind(requiredCount,3, 3, 4, 5, 6));
    }

    @Test
    public void three_of_a_kind_returns_sum_of_three_even_if_there_is_a_four_of_a_kind() {
        int requiredCount = 3;
        assertEquals(9, yatzy.nOfAKind(requiredCount,3, 3, 3, 3, 1));
    }

    // Four of a kind category
    @Test
    public void four_of_a_kind_returns_sum_of_four_equal_values() {
        int requiredCount = 4;
        assertEquals(8, yatzy.nOfAKind(requiredCount,2, 2, 2, 2, 5));
    }

    @Test
    public void four_of_a_kind_returns_0_when_there_is_no_four_of_a_kind() {
        int requiredCount = 4;
        assertEquals(0, yatzy.nOfAKind(requiredCount,2, 2, 2, 5, 5));
    }

    @Test
    public void four_of_a_kind_returns_sum_of_four_when_all_dice_are_equal() {
        int requiredCount = 4;
        assertEquals(8, yatzy.nOfAKind(requiredCount,2, 2, 2, 2, 2));
    }

    // Small straight category
    @Test
    public void small_straight_returns_sum_of_all_dice_when_there_are_all_numbers_from_1_to_5() {
        assertEquals(15, yatzy.smallStraight(1, 2, 3, 4, 5));
    }

    @Test
    public void small_straight_returns_sum_of_all_dice_when_there_are_all_numbers_from_1_to_5_in_any_order() {
        assertEquals(15, yatzy.smallStraight(5, 4, 3, 2, 1));
    }

    @Test
    public void small_straight_returns_0_when_there_are_not_all_numbers_from_1_to_5() {
        assertEquals(0, yatzy.smallStraight(2, 3, 4, 5, 6));
    }

    // Large straight category
    @Test
    public void large_straight_returns_sum_of_all_dice_when_there_are_all_numbers_from_2_to_6() {
        assertEquals(20, yatzy.largeStraight(2, 3, 4, 5, 6));
    }

    @Test
    public void large_straight_returns_sum_of_all_dice_when_there_are_all_numbers_from_2_to_6_in_any_order() {
        assertEquals(20, yatzy.largeStraight(6, 5, 4, 3, 2));
    }

    @Test
    public void large_straight_returns_0_when_there_are_not_all_numbers_from_2_to_6() {
        assertEquals(0, yatzy.largeStraight(2, 3, 4, 5, 1));
    }

    // Full house category
    @Test
    public void full_house_returns_sum_of_all_dice_when_there_are_a_pair_and_a_three_of_a_kind() {
        assertEquals(8, yatzy.fullHouse(1, 1, 2, 2, 2));
    }

    @Test
    public void full_house_returns_0_when_there_are_no_pair_and_three_of_a_kind() {
        assertEquals(0, yatzy.fullHouse(2, 2, 3, 3, 4));
    }

    @Test
    public void full_house_returns_0_when_all_dice_values_are_equals() {
        assertEquals(0, yatzy.fullHouse(4, 4, 4, 4, 4));
    }
}
