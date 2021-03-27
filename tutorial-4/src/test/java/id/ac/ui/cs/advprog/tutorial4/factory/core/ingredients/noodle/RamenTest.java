package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.noodle;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RamenTest {

    @Test
    public void testDescription() {
        Ramen newflavor = new Ramen();
        assertEquals("Adding Inuzuma Ramen Noodles...", newflavor.getDescription());
    }
}
