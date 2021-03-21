package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class StaffOfHoumoTest {
    private Class<?> staffOfHoumoClass;

    @BeforeEach
    public void setUp() throws Exception {
        staffOfHoumoClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.StaffOfHoumo");
    }

    @Test
    public void testStaffOfHoumoIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(staffOfHoumoClass.getModifiers()));
    }

    @Test
    public void testStaffOfHoumoIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(staffOfHoumoClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testStaffOfHoumoOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = staffOfHoumoClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testStaffOfHoumoOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = staffOfHoumoClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testStaffOfHoumoOverrideGetNameMethod() throws Exception {
        Method getName = staffOfHoumoClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testStaffOfHoumoOverrideGetHolderMethod() throws Exception {
        Method getHolderName = staffOfHoumoClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method

    @Test
    public void testGetName() throws Exception{
        StaffOfHoumo staffOfHoumo = new StaffOfHoumo("dummy");

        assertEquals("Staff of Houmo",staffOfHoumo.getName());
    }

    @Test
    public void testGetHolderName() throws Exception{
        StaffOfHoumo staffOfHoumo = new StaffOfHoumo("dummy");

        assertEquals("dummy",staffOfHoumo.getHolderName());
    }

    @Test
    public void testNormalAttack() throws Exception{
        StaffOfHoumo staffOfHoumo = new StaffOfHoumo("dummy");
        String res = staffOfHoumo.normalAttack();

        assertEquals(staffOfHoumo.getName() + " normal attack",res);
    }

    @Test
    public void testChargedAttack() throws Exception{
        StaffOfHoumo staffOfHoumo = new StaffOfHoumo("dummy");
        String res = staffOfHoumo.chargedAttack();

        assertEquals(staffOfHoumo.getName() + " charged attack", res);
    }
}
