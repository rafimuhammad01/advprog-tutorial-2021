package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.meet;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BeefTest {

    @Test
    public void testDescription() {
        Beef newflavor = new Beef();
        assertEquals("Adding Maro Beef Meat...", newflavor.getDescription());
    }
}
