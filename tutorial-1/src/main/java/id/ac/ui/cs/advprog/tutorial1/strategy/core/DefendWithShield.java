package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithShield implements DefenseBehavior {
    //ToDo: Complete me
    @Override
    public String getType() {
        return "DefenseWithShield";
    }

    public String defend() {
        return "Shield";
    }
}
