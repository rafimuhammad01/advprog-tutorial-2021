package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.SeawardPride;
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
public class BowAdapterTest {
    private Class<?> bowAdapterClass;
    private Class<?> bowClass;

    @BeforeEach
    public void setUp() throws Exception {
        bowAdapterClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.BowAdapter");
        bowClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow");
    }

    @Test
    public void testBowAdapterIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(bowAdapterClass.getModifiers()));
    }

    @Test
    public void testBowAdapterIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(bowAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testBowAdapterConstructorReceivesBowAsParameter() {
        Class<?>[] classArg = new Class[1];
        classArg[0] = bowClass;
        Collection<Constructor<?>> constructors = Arrays.asList(
                bowAdapterClass.getDeclaredConstructors());

        assertTrue(constructors.stream()
                .anyMatch(type -> Arrays.equals(
                        type.getParameterTypes(), classArg)));
    }

    @Test
    public void testBowAdapterOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = bowAdapterClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testBowAdapterOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = bowAdapterClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testBowAdapterOverrideGetNameMethod() throws Exception {
        Method getName = bowAdapterClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testBowAdapterOverrideGetHolderMethod() throws Exception {
        Method getHolderName = bowAdapterClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method

    @Test
    public void testNormalAttack() throws Exception {
        Bow bow = mock(Bow.class);
        BowAdapter bowAdapter = new BowAdapter(bow);

        assertEquals(bow.getHolderName()  + " with " + bow.getName() +" (normal attack): " + bow.shootArrow(false), bowAdapter.normalAttack());

    }

    @Test
    public void testChargedAttack() throws Exception {
        Bow bow = mock(Bow.class);
        BowAdapter bowAdapter = new BowAdapter(bow);

        assertEquals(bow.getHolderName()  + " with " + bow.getName() + " (charged attack): Entering aim shot mode", bowAdapter.chargedAttack());

    }
    @Test
    public void testGetName() throws Exception{
        Bow bow = new IonicBow("dummy");
        BowAdapter bowAdapter = new BowAdapter(bow);

        assertEquals("Ionic Bow",bowAdapter.getName());
    }

    @Test
    public void testGetHolderName() throws Exception{
        Bow bow = new IonicBow("dummy");
        BowAdapter bowAdapter = new BowAdapter(bow);

        assertEquals("dummy",bowAdapter.getHolderName());
    }
}
