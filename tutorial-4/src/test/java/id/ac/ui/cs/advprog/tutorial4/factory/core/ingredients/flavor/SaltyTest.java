package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.flavor;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaltyTest {
    @Test
    public void testDescription() {
        Salty newflavor = new Salty();
        assertEquals("Adding a pinch of salt...", newflavor.getDescription());
    }
}
