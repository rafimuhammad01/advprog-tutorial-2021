package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithArmor implements DefenseBehavior {
    //ToDo: Complete me
    @Override
    public String getType() {
        return "DefenseWithArmor";
    }

    public String defend() {
        return "Armor";
    }
}
