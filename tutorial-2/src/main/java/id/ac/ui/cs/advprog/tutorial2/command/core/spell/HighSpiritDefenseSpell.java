package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;

public class HighSpiritDefenseSpell extends HighSpiritSpell {
    // TODO: Complete Me

    public HighSpiritDefenseSpell(HighSpirit spirit) {
        super(spirit);
    }

    @Override
    public void cast() {
        spirit.defenseStance();
    }

    @Override
    public String spellName() {
        return spirit.getRace() + ":Defense";
    }
}
