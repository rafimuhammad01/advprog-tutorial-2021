package id.ac.ui.cs.tutorial0.controller;

import id.ac.ui.cs.tutorial0.service.AdventurerCalculatorService;
import id.ac.ui.cs.tutorial0.service.PowerClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdventurerController {

    @Autowired
    private AdventurerCalculatorService adventurerCalculatorService;
    @Autowired
    private PowerClassifier powerClassifier;


    @RequestMapping("/adventurer/countPower")
    private String showAdventurerPowerFromBirthYear(@RequestParam("birthYear")int birthYear, Model model) {
        int power = adventurerCalculatorService.countPowerPotensialFromBirthYear(birthYear);
        model.addAttribute("power", power);
        model.addAttribute("class", powerClassifier.powerClassification(power));

        return "calculator";
    }
}
