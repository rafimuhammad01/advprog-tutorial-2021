package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithBarrier implements DefenseBehavior {
    //ToDo: Complete me
    @Override
    public String getType() {
        return "DefenseWithBarrier";
    }

    public String defend() {
        return "Barrier";
    }
}
