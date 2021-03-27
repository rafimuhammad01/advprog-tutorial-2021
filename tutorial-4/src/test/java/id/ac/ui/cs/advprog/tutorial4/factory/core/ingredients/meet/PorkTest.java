package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.meet;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PorkTest {
    @Test
    public void testDescription() {
        Pork newflavor = new Pork();
        assertEquals("Adding Tian Xu Pork Meat...", newflavor.getDescription());
    }
}
