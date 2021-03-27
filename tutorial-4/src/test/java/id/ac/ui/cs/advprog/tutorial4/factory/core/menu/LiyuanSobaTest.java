package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LiyuanSobaTest {

    private Class<?> liyuanSobaClass;

    @BeforeEach
    public void setUp() throws Exception {
        liyuanSobaClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba");
    }

    @Test
    public void testLiyuanSobaIsConcreteClass() {
        assertFalse(Modifier.isAbstract(liyuanSobaClass.getModifiers()));
    }

    @Test
    public void testLiyuanSobaIsAnMenu() {
        Class<?> parentClass = liyuanSobaClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testIngredientsType() {
        LiyuanSoba liyuanSoba = new LiyuanSoba("dummy");
        assertEquals(liyuanSoba.getNoodle().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba");
        assertEquals(liyuanSoba.getMeat().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef");
        assertEquals(liyuanSoba.getTopping().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Mushroom");
        assertEquals(liyuanSoba.getFlavor().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet");

    }
}
