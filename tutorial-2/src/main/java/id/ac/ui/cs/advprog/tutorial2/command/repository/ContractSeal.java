package id.ac.ui.cs.advprog.tutorial2.command.repository;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContractSeal {

    private Map<String, Spell> spells;

    public ContractSeal() {
        spells = new HashMap<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void castSpell(String spellName) {
        // TODO: Complete Me
        spells.get(spellName).cast();
    }

    public void undoSpell() {
        // TODO: Complete Me
        for(Spell i : getSpells()) {
            i.undo();
        }

    }

    public Collection<Spell> getSpells() { return spells.values(); }
}
