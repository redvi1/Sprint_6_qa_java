import com.example.Feline;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void getFamilyReturnsCatsFamily() {
        Feline feline = new Feline();

        String family = feline.getFamily();

        assertEquals("Кошачьи", family);
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        List<String> expectedFood =
                Arrays.asList("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, food);
    }

    @Test
    public void getKittensWithoutParamsReturnsOne() {
        Feline feline = new Feline();

        int kittens = feline.getKittens();

        assertEquals(1, kittens);
    }
}
