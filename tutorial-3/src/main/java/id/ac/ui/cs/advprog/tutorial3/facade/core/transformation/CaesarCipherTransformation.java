package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;

public class CaesarCipherTransformation implements Transformation {

    int shiftKey;
    public CaesarCipherTransformation(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public CaesarCipherTransformation() {
        this(5);
    }

    private StringBuffer process(Spell spell, boolean isEncode) {
        StringBuffer result= new StringBuffer();
        Codex codex = spell.getCodex();

        if (isEncode) {
            for (int i=0; i<spell.getText().length(); i++) {

                int oldIdx = (codex.getIndex(spell.getText().charAt(i)));
                int newIdx = (oldIdx + shiftKey ) % codex.getCharSize();

                char newChar = codex.getChar(newIdx);

                result.append(newChar);

                /*
                if (Character.isUpperCase(spell.getText().charAt(i))) {
                    char ch = (char)(((int)spell.getText().charAt(i) + shiftKey - 65) % 26 + 65);
                    result.append(ch);
                }

                else {
                    char ch = (char)(((int)spell.getText().charAt(i) + shiftKey - 97) % 26 + 97);
                    result.append(ch);
                }

                 */
            }
        } else {
            for (int i=0; i<spell.getText().length(); i++) {
                int oldIdx = (codex.getIndex(spell.getText().charAt(i)));
                int newIdx = (oldIdx - shiftKey ) % codex.getCharSize();

                if (newIdx<0) newIdx += codex.getCharSize();

                char newChar = codex.getChar(newIdx);

                result.append(newChar);

                /*
                if (Character.isUpperCase(spell.getText().charAt(i))) {
                    char ch = (char)(((int)spell.getText().charAt(i) - shiftKey - 65) % 26 + 65);
                    result.append(ch);
                }

                else {
                    char ch = (char)(((int)spell.getText().charAt(i) - shiftKey - 97) % 26 + 97);
                    result.append(ch);
                }

                 */
            }
        }
        return result;
    }

    @Override
    public Spell encode(Spell spell) {

        StringBuffer result = process(spell, true);
        return new Spell(result.toString(), spell.getCodex());
    }

    @Override
    public Spell decode(Spell spell) {
        StringBuffer result = process(spell, false);
        return new Spell(result.toString(), spell.getCodex());
    }
}
