import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private final Yatzy yatzy = new Yatzy();

    @Test
    public void chance_returns_14_given_1_1_3_3_6() {
        assertEquals(14, yatzy.chance(1,1,3,3,6));
    }
}
