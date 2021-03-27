package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.flavor;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SweetTest {

    @Test
    public void testDescription() {
        Sweet newflavor = new Sweet();
        assertEquals("Adding a dash of Sweet Soy Sauce...", newflavor.getDescription());
    }
}
