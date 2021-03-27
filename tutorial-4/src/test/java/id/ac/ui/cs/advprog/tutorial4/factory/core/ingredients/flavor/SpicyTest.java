package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.flavor;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpicyTest {

    @Test
    public void testDescription() {
        Spicy newflavor = new Spicy();
        assertEquals("Adding Liyuan Chili Powder...", newflavor.getDescription());
    }
}
