package id.ac.ui.cs.advprog.tutorial2.command.repository;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContractSeal {
    private Spell latestSpell;

    private Map<String, Spell> spells;

    public ContractSeal() {
        spells = new HashMap<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void addLatestSpell(Spell latestSpell) {
        this.latestSpell = latestSpell;
    }

    public void castSpell(String spellName) {
        // TODO: Complete Me
        spells.get(spellName).cast();
        addLatestSpell(spells.get(spellName));
    }

    public void undoSpell() {
        // TODO: Complete Me
        latestSpell.undo();

    }

    public Collection<Spell> getSpells() { return spells.values(); }
}
