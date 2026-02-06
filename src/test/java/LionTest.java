import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void getFoodReturnsValueFromFeline() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", feline);

        assertEquals(expectedFood, lion.getFood());
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void constructorThrowsExceptionForInvalidSex() {
        try {
            new Lion("Котик", feline);
            fail("Ждали исключение, но его не было");
        } catch (Exception exception) {
            assertEquals(
                    "Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage()
            );
        }
    }
}
