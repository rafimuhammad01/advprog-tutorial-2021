package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class MysticAdventurer extends Adventurer {

    public MysticAdventurer(Guild guild) {
        this.name = "Mystic";
        //ToDo: Complete Me
        this.guild = guild;
    }

    //ToDo: Complete Me
    public void update() {

        if (this.guild.getQuestType().equals("D") || this.guild.getQuestType().equals("E")) {
            getQuests().add(this.guild.getQuest());
        }
    }
}
