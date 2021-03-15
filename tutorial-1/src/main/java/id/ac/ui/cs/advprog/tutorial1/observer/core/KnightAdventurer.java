package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class KnightAdventurer extends Adventurer {

    public KnightAdventurer(Guild guild) {
        this.name = "Knight";
        //ToDo: Complete Me
        this.guild = guild;
    }

    //ToDo: Complete Me
    public void update(){
        getQuests().add(this.guild.getQuest());


    }
}
