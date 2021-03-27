package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.noodle;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiratakiTest {

    @Test
    public void testDescription() {
        Shirataki newflavor = new Shirataki();
        assertEquals("Adding Snevnezha Shirataki Noodles...", newflavor.getDescription());
    }
}
