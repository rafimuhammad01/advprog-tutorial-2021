package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithMagic implements AttackBehavior {
    //ToDo: Complete me

    @Override
    public String getType() {
        return "AttackWithMagic";
    }

    public String attack() {
        return "Magic";
    }
}
