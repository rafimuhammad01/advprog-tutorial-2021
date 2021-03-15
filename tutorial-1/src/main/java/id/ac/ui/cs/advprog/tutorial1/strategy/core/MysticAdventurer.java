package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class MysticAdventurer extends Adventurer {
    //ToDo: Complete me

    public MysticAdventurer() {
        super();
        setAttackBehavior(new AttackWithMagic());
        setDefenseBehavior(new DefendWithShield());
    }

    public String getAlias() {
        return "Mystic";
    }
}
