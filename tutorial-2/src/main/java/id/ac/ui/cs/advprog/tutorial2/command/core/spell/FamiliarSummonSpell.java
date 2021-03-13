package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;

public class FamiliarSummonSpell extends FamiliarSpell {
	// TODO: Complete Me

    public FamiliarSummonSpell(Familiar familiar) {
        super(familiar);
    }

    @Override
    public void cast(){
        familiar.summon();
    }

    @Override
    public String spellName() {
        return familiar.getRace() + ":Summon";
    }
}
