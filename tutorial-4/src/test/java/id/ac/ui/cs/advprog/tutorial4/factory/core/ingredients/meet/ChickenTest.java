package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.meet;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChickenTest {
    @Test
    public void testDescription() {
        Chicken newflavor = new Chicken();
        assertEquals("Adding Wintervale Chicken Meat...", newflavor.getDescription());
    }
}
