import com.example.Feline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0},
                {1},
                {7},
                {10}
        });
    }

    @Test
    public void getKittensWithParamReturnsSameValue() {
        Feline feline = new Feline();

        int result = feline.getKittens(kittensCount);

        assertEquals(kittensCount, result);
    }
}
