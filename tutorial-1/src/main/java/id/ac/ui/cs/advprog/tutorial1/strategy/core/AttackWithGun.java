package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithGun implements AttackBehavior {
    //ToDo: Complete me

    @Override
    public String getType() {
        return "AttackWithGun";
    }

    public String attack() {
        return "Gun";
    }
}
