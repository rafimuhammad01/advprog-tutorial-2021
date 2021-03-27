package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.noodle;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SobaTest {
    @Test
    public void testDescription() {
        Soba newflavor = new Soba();
        assertEquals("Adding Liyuan Soba Noodles...", newflavor.getDescription());
    }
}
