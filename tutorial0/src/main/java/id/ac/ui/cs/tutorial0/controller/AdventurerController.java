package id.ac.ui.cs.tutorial0.controller;

import id.ac.ui.cs.tutorial0.service.AdventurerCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdventurerController {

    @Autowired
    private AdventurerCalculatorService adventurerCalculatorService;

    @RequestMapping("/adventurer/countPower")
    private String showAdventurerPowerFromBirthYear(@RequestParam("birthYear")int birthYear, Model model) {
        String powerInString = "";
        int power = adventurerCalculatorService.countPowerPotensialFromBirthYear(birthYear);

        if (power < 20000) {
            powerInString += power + " C class";
        } else if (power >= 20000 && power < 100000) {
            powerInString += power + " B class";
        } else {
            powerInString += power + " A class";
        }

        model.addAttribute("power", powerInString);

        return "calculator";
    }
}
