package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class KnightAdventurer extends Adventurer {
    //ToDo: Complete me

    public KnightAdventurer() {
        super();
        setAttackBehavior(new AttackWithSword());
        setDefenseBehavior(new DefendWithArmor());
    }

    public String getAlias() {
        return "Knight";
    }
}
