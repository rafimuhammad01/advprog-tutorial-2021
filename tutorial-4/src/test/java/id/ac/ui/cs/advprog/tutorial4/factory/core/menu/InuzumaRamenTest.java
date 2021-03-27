package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InuzumaRamenTest {

    private Class<?> inuzumaRamenClass;

    @BeforeEach
    public void setUp() throws Exception {
        inuzumaRamenClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen");
    }

    @Test
    public void testInuzumaRamenIsConcreteClass() {
        assertFalse(Modifier.isAbstract(inuzumaRamenClass.getModifiers()));
    }

    @Test
    public void testInuzumaRamenIsAnMenu() {
        Class<?> parentClass = inuzumaRamenClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testIngredientsType() {
        InuzumaRamen inuzumaRamen = new InuzumaRamen("dummy");
        assertEquals(inuzumaRamen.getNoodle().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen");
        assertEquals(inuzumaRamen.getMeat().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork");
        assertEquals(inuzumaRamen.getTopping().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg");
        assertEquals(inuzumaRamen.getFlavor().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy");

    }
}
