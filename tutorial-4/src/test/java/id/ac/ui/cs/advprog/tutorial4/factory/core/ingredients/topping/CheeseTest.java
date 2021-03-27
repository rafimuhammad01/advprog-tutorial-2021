package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.topping;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheeseTest {
    @Test
    public void testDescription() {
        Cheese newflavor = new Cheese();
        assertEquals("Adding Shredded Cheese Topping...", newflavor.getDescription());
    }
}
