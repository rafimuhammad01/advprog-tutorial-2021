package id.ac.ui.cs.advprog.tutorial3.adapter.service;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.BowAdapter;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.SpellbookAdapter;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.BowRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.LogRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.SpellbookRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.WeaponRepository;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Complete me. Modify this class as you see fit~
@Service
public class WeaponServiceImpl implements WeaponService {

    // feel free to include more repositories if you think it might help :)

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private BowRepository bowRepository;

    @Autowired
    private SpellbookRepository spellBookRepository;

    List<Weapon> allItems = new ArrayList<>();


    public Weapon findByAlias(String weaponName) {
        for (Weapon i : allItems) {
            if (i.getName().equals(weaponName)) {
                return i;
            }
        }
        return null;
    }

    public void addItem(){
        //add weapon repo
        allItems.addAll(weaponRepository.findAll());

        //Adding bow repo
        for (Bow i : bowRepository.findAll()){
            allItems.add(new BowAdapter(i));
        }

        //Adding spellbook repo
        for (Spellbook i : spellBookRepository.findAll()){
            allItems.add(new SpellbookAdapter(i));
        }
    }

    // TODO: implement me
    @Override
    public List<Weapon> findAll() {
        if (allItems.isEmpty()) {
            addItem();
        }
        return allItems;
    }

    // TODO: implement me
    @Override
    public void attackWithWeapon(String weaponName, int attackType) {
        //Get Weapon
        Weapon weapon = findByAlias(weaponName);

        if (weapon == null) {
            weapon = weaponRepository.findByAlias(weaponName);
            weaponRepository.save(weapon);
            allItems.add(weapon);
        }

        if (weapon == null) {
            Bow bow = bowRepository.findByAlias(weaponName);
            bowRepository.save(bow);
            allItems.add(new BowAdapter(bow));
        }

        if (weapon == null) {
            Spellbook spellbook = spellBookRepository.findByAlias(weaponName);
            spellBookRepository.save(spellbook);
            allItems.add(new SpellbookAdapter(spellbook));
        }

        //Attack with normal or charged
        if (attackType == 0) { //Attack type 0 == normalAttack
            logRepository.addLog(weapon.normalAttack());
        }
        else if (attackType == 1) { //Attack type 1 == chargedAttack
            logRepository.addLog(weapon.chargedAttack());
        }
    }

    // TODO: implement me
    @Override
    public List<String> getAllLogs() {
        return logRepository.findAll();
    }
}




