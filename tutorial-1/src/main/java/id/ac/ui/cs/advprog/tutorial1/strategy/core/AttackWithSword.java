package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithSword implements AttackBehavior {
    //ToDo: Complete me

    @Override
    public String getType() {
        return "AttackWithSword";
    }

    public String attack() {
        return "Sword";
    }
}
