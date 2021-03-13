package id.ac.ui.cs.advprog.tutorial2.template.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SpiritInQuest {

    public List attackPattern() {
        List list = new ArrayList();
        // TODO: Complete Me
        list.addAll(Arrays.asList(this.summon(), this.getReady(), this.buff(), this.attackWithBuster(), this.attackWithQuick(), this.attackWithArts(), this.attackWithSpecialSkill()));
        return list;
    }


    public String summon() {
        return "Summon a Spirit...";
    }

    public String getReady() {
        return "Spirit ready to enter the Quest";
    }

    protected abstract String buff();

    protected abstract String attackWithBuster();

    protected abstract String attackWithQuick();

    protected abstract String attackWithArts();

    protected abstract String attackWithSpecialSkill();
}
