package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.AlphaCodex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaesarCipherTransformationTest {
    private Class<?> caesarChiperClass;

    @BeforeEach
    public void setup() throws Exception {
        caesarChiperClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.facade.core.transformation.CaesarCipherTransformation");

    }

    @Test
    public void testCaesarChiperHasEncodeMehthod() throws Exception {
        Method translate =  caesarChiperClass.getDeclaredMethod("encode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCaesarChiperEncodesCorrectly() throws Exception {
        String text = "dummy";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);

        String expected = "izrr3";
        Spell result = new CaesarCipherTransformation().encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCaesarChiperEncodesCorrectlyWithCustomKey() throws Exception {
        String text = "dummy";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);

        String expected = "n4ww8";
        Spell result = new CaesarCipherTransformation(10).encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testAbyssalHasDecodeMethod() throws Exception {
        Method translate =  caesarChiperClass.getDeclaredMethod("encode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCaesarChiperDecodesCorrectly() throws Exception {
        String text = "izrr3";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);

        String expected = "dummy";
        Spell result = new CaesarCipherTransformation().decode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCaesarChiperDecodesCorrectlyWithCustomKey() throws Exception {
        String text = "n4ww8";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);

        String expected = "dummy";
        Spell result = new CaesarCipherTransformation(10).decode(spell);
        assertEquals(expected, result.getText());
    }

}
