package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.meet;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FishTest {
    @Test
    public void testDescription() {
        Fish newflavor = new Fish();
        assertEquals("Adding Zhangyun Salmon Fish Meat...", newflavor.getDescription());
    }
}
