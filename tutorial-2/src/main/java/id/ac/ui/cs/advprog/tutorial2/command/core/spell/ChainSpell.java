package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import java.util.ArrayList;

public class ChainSpell implements Spell {
    // TODO: Complete Me
    ArrayList<Spell> arrSpell;

    public ChainSpell(ArrayList<Spell> arrSpell){
        this.arrSpell = arrSpell;
    }

    @Override
    public void cast() {
        for (Spell i : arrSpell) {
            i.cast();
        }
    }

    @Override
    public void undo() {
        for (int i = arrSpell.size() - 1; i >= 0; i-- ) {
            arrSpell.get(i).cast();
        }
    }


    @Override
    public String spellName() {
        return "ChainSpell";
    }
}
