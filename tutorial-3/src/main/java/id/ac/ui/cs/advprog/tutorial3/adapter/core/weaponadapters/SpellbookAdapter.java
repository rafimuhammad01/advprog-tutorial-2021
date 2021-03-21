package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class SpellbookAdapter implements Weapon {

    private Spellbook spellbook;
    boolean isLastSpellChargedAttack;

    public SpellbookAdapter(Spellbook spellbook) {
        this.spellbook = spellbook;
    }


    @Override
    public String normalAttack() {
        isLastSpellChargedAttack = false;
        return spellbook.getHolderName()  + " with " + spellbook.getName() +" (normal attack): " + spellbook.smallSpell();
    }

    @Override
    public String chargedAttack() {
        if (isLastSpellChargedAttack) {
            return spellbook.getHolderName()  + " with " + spellbook.getName() +" (charged attack): " + "Magic power not enough for large spell";
        }
        isLastSpellChargedAttack = true;
        return spellbook.getHolderName()  + " with " + spellbook.getName() +" (charged attack): " + spellbook.largeSpell();
    }

    @Override
    public String getName() {
        return spellbook.getName();
    }

    @Override
    public String getHolderName() {
        return spellbook.getHolderName();
    }

}
