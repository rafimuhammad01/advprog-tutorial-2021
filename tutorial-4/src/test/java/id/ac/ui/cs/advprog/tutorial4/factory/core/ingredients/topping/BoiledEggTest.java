package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.topping;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoiledEggTest {

    @Test
    public void testDescription() {
        BoiledEgg newflavor = new BoiledEgg();
        assertEquals("Adding Guahuan Boiled Egg Topping", newflavor.getDescription());
    }
}
