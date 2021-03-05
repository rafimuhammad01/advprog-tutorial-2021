package id.ac.ui.cs.advprog.tutorial1.observer.service;

import id.ac.ui.cs.advprog.tutorial1.observer.core.*;
import id.ac.ui.cs.advprog.tutorial1.observer.repository.QuestRepository;
import id.ac.ui.cs.advprog.tutorial1.observer.core.Adventurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildServiceImpl implements GuildService {
    private final QuestRepository questRepository;
    private final Guild guild;
    private final Adventurer agileAdventurer;
    private final Adventurer knightAdventurer;
    private final Adventurer mysticAdventurer;

    public GuildServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
        this.guild = new Guild();
        //ToDo : Complete Me
        this.agileAdventurer = new AgileAdventurer(this.guild);
        this.knightAdventurer = new KnightAdventurer(this.guild);
        this.mysticAdventurer = new MysticAdventurer(this.guild);
    }

    //ToDo: Complete Me
    public void addQuest(Quest quest){
        questRepository.save(quest);
        guild.addQuest(quest);
        return;
    }

    public List<Adventurer> getAdventurers() {
        return this.guild.getAdventurers();
    }
}