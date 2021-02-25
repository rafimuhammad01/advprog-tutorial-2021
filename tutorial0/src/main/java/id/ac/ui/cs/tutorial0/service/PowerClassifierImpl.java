package id.ac.ui.cs.tutorial0.service;

import org.springframework.stereotype.Service;


@Service
public class PowerClassifierImpl implements PowerClassifier {
    @Override
    public String powerClassification (int power) {
        if (power < 20000) {
            return "C class";
        } else if (power >= 20000 && power < 100000) {
            return  "B class";
        } else {
            return "A class";
        }


    }

}
