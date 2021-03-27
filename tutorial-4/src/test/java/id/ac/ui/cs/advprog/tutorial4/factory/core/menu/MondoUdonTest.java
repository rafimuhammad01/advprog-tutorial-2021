package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MondoUdonTest {
    private Class<?> mondoUdonClass;

    @BeforeEach
    public void setUp() throws Exception {
        mondoUdonClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon");
    }

    @Test
    public void testMondoUdonIsConcreteClass() {
        assertFalse(Modifier.isAbstract(mondoUdonClass.getModifiers()));
    }

    @Test
    public void testMondoUdonIsAnMenu() {
        Class<?> parentClass = mondoUdonClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testIngredientsType() {
        MondoUdon mondoUdon = new MondoUdon("dummy");
        assertEquals(mondoUdon.getNoodle().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon");
        assertEquals(mondoUdon.getMeat().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken");
        assertEquals(mondoUdon.getTopping().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese");
        assertEquals(mondoUdon.getFlavor().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty");

    }


}
