import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private final Yatzy yatzy = new Yatzy();

    @Test
    public void chance_returns_14_given_1_1_3_3_6() {
        assertEquals(14, yatzy.chance(1,1,3,3,6));
    }

    @Test
    public void chance_returns_21_given_4_5_5_6_1() {
        assertEquals(21, yatzy.chance(4,5,5,6,1));
    }

    @Test
    public void yatzy_returns_50_given_1_1_1_1_1() {
        assertEquals(50, yatzy.yatzy(1,1,1,1,1));
    }

    @Test
    public void yatzy_returns_0_given_1_1_1_2_1() {
        assertEquals(50, yatzy.yatzy(1,1,1,1,1));
    }
}
