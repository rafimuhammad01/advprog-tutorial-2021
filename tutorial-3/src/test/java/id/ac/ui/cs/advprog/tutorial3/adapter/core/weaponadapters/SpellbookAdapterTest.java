package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Heatbearer;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

// TODO: add tests
public class SpellbookAdapterTest {
    private Class<?> spellbookAdapterClass;
    private Class<?> spellbookClass;

    @BeforeEach
    public void setUp() throws Exception {
        spellbookAdapterClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.SpellbookAdapter");
        spellbookClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook");
    }

    @Test
    public void testSpellbookAdapterIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(spellbookAdapterClass.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(spellbookAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testSpellbookAdapterConstructorReceivesSpellbookAsParameter() {
        Class<?>[] classArg = new Class[1];
        classArg[0] = spellbookClass;
        Collection<Constructor<?>> constructors = Arrays.asList(
                spellbookAdapterClass.getDeclaredConstructors());

        assertTrue(constructors.stream()
                .anyMatch(type -> Arrays.equals(
                        type.getParameterTypes(), classArg)));
    }

    @Test
    public void testSpellbookAdapterOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = spellbookAdapterClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = spellbookAdapterClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideGetNameMethod() throws Exception {
        Method getName = spellbookAdapterClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideGetHolderMethod() throws Exception {
        Method getHolderName = spellbookAdapterClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method

    @Test
    public void testNormalAttack() throws Exception {
        Spellbook spellbook = mock(Spellbook.class);
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(spellbook);

        assertEquals(spellbook.getHolderName()  + " with " + spellbook.getName() +" (normal attack): " + spellbook.smallSpell(), spellbookAdapter.normalAttack());

    }

    @Test
    public void testChargedAttack() throws Exception {
        Spellbook spellbook = mock(Spellbook.class);
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(spellbook);

        assertEquals(spellbook.getHolderName()  + " with " + spellbook.getName() +" (charged attack): " + spellbook.largeSpell(), spellbookAdapter.chargedAttack());

    }
    @Test
    public void testGetName() throws Exception{
        Spellbook spellbook = new Heatbearer("dummy");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(spellbook);

        assertEquals("Heat Bearer",spellbookAdapter.getName());
    }

    @Test
    public void testGetHolderName() throws Exception{
        Spellbook spellbook = new Heatbearer("dummy");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(spellbook);

        assertEquals("dummy",spellbookAdapter.getHolderName());
    }
}
