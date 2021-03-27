package id.ac.ui.cs.advprog.tutorial4.factory.core.ingredients.flavor;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UmamiTest {

    @Test
    public void testDescription() {
        Umami newflavor = new Umami();
        assertEquals("Adding WanPlus Specialty MSG flavoring...", newflavor.getDescription());
    }
}
