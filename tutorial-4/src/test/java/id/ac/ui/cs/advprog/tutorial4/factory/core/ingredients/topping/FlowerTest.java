package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.topping;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlowerTest {

    @Test
    public void testDescription() {
        Flower newflavor = new Flower();
        assertEquals("Adding Xinqin Flower Topping...", newflavor.getDescription());
    }
}
