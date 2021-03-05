package id.ac.ui.cs.advprog.tutorial1.observer.core;


public class AgileAdventurer extends Adventurer {

    public AgileAdventurer(Guild guild) {
        this.name = "Agile";
        //ToDo: Complete Me
        this.guild = guild;
    }

    //ToDo: Complete Me
    public void update() {

        if (this.guild.getQuestType().equals("D") || this.guild.getQuestType().equals("R")){
            getQuests().add(this.guild.getQuest());
        };
        /*
        if (this.guild.getQuest().getType().equals("D") || this.guild.getQuest().getType().equals("R")) {
            getQuests().add(this.guild.getQuest());
        }

         */
    }
}
