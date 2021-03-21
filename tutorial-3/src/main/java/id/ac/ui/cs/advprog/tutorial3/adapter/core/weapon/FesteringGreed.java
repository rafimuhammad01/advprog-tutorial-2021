package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

public class FesteringGreed implements Weapon {

    private String holderName;

    public FesteringGreed(String holderName) {
        this.holderName = holderName;
    }
    @Override
    public String normalAttack() {
        // TODO: complete me
        return getName() + " normal attack";
    }

    @Override
    public String chargedAttack() {
        // TODO: complete me
        return getName() + " charged attack";
    }

    @Override
    public String getName() {
        return "Festering Greed";
    }

    @Override
    public String getHolderName() { return holderName; }
}
