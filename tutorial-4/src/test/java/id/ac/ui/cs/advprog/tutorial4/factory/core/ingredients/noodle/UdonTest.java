package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.noodle;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UdonTest {

    @Test
    public void testDescription() {
        Udon newflavor = new Udon();
        assertEquals("Adding Mondo Udon Noodles...", newflavor.getDescription());
    }
}
