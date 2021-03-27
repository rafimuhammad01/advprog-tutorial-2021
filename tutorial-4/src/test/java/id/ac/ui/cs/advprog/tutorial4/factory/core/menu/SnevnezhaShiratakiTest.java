package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SnevnezhaShiratakiTest {

    private Class<?> snevnezhaShiratakiClass;

    @BeforeEach
    public void setUp() throws Exception {
        snevnezhaShiratakiClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon");
    }

    @Test
    public void testSnevnezhaShiratakiIsConcreteClass() {
        assertFalse(Modifier.isAbstract(snevnezhaShiratakiClass.getModifiers()));
    }

    @Test
    public void testSnevnezhaShiratakiIsAnMenu() {
        Class<?> parentClass = snevnezhaShiratakiClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testIngredientsType() {
        SnevnezhaShirataki snevnezhaShirataki = new SnevnezhaShirataki("dummy");
        assertEquals(snevnezhaShirataki.getNoodle().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki");
        assertEquals(snevnezhaShirataki.getMeat().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish");
        assertEquals(snevnezhaShirataki.getTopping().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower");
        assertEquals(snevnezhaShirataki.getFlavor().getClass().getName(), "id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami");

    }
}
