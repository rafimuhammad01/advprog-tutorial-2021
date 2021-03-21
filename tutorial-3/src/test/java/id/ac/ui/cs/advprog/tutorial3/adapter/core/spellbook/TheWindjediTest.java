package id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class TheWindjediTest {
    private Class<?> theWindjediClass;

    @BeforeEach
    public void setUp() throws Exception {
        theWindjediClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi");
    }

    @Test
    public void testTheWindjediIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(theWindjediClass.getModifiers()));
    }

    @Test
    public void testTheWindjediIsASpellbook() {
        Collection<Type> interfaces = Arrays.asList(theWindjediClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook")));
    }

    @Test
    public void testTheWindjediOverrideSmallSpellMethod() throws Exception {
        Method smallSpell = theWindjediClass.getDeclaredMethod("smallSpell");

        assertEquals("java.lang.String",
                smallSpell.getGenericReturnType().getTypeName());
        assertEquals(0,
                smallSpell.getParameterCount());
        assertTrue(Modifier.isPublic(smallSpell.getModifiers()));
    }

    @Test
    public void testTheWindjediOverrideLargeSpellMethod() throws Exception {
        Method largeSpell = theWindjediClass.getDeclaredMethod("largeSpell");

        assertEquals("java.lang.String",
                largeSpell.getGenericReturnType().getTypeName());
        assertEquals(0,
                largeSpell.getParameterCount());
        assertTrue(Modifier.isPublic(largeSpell.getModifiers()));
    }

    @Test
    public void testTheWindjediOverrideGetNameMethod() throws Exception {
        Method getName = theWindjediClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testTheWindjediOverrideGetHolderMethod() throws Exception {
        Method getHolderName = theWindjediClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method

    @Test
    public void testGetName() throws Exception{
        TheWindjedi theWindjedi = new TheWindjedi("dummy");

        assertEquals("The Windjedi",theWindjedi.getName());
    }

    @Test
    public void testGetHolderName() throws Exception{
        TheWindjedi theWindjedi = new TheWindjedi("dummy");

        assertEquals("dummy",theWindjedi.getHolderName());
    }

    @Test
    public void testSmallSpell() throws Exception{
        TheWindjedi theWindjedi = new TheWindjedi("dummy");
        String res = theWindjedi.smallSpell();

        assertEquals("Small musical attack launched",res);
    }

    @Test
    public void testLargeSpell() throws Exception{
        TheWindjedi theWindjedi = new TheWindjedi("dummy");
        String res = theWindjedi.smallSpell();

        assertEquals("Orchestra-class music attack launched", res);
    }
}
