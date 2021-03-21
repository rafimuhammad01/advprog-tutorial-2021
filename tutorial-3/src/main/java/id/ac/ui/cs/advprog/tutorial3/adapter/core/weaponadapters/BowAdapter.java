package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class BowAdapter implements Weapon {

    private Bow bow;
    boolean isAimShot;

    public BowAdapter(Bow bow) {
        this.bow = bow;
    }

    @Override
    public String normalAttack() {
        return bow.getHolderName()  + " with " + bow.getName() +" (normal attack): " + bow.shootArrow(isAimShot);

    }

    @Override
    public String chargedAttack() {
        if (isAimShot) {
            isAimShot = false;
            return bow.getHolderName()  + " with " + bow.getName() + " (charged attack): Leaving aim shot mode";
        } else {
            isAimShot = true;
            return bow.getHolderName() + " with " + bow.getName() + " (charged attack): Entering aim shot mode";
        }

    }

    @Override
    public String getName() {
        return bow.getName();
    }

    @Override
    public String getHolderName() {
        // TODO: complete me
        return bow.getHolderName();
    }
}
