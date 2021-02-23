package id.ac.ui.cs.tutorial0.service;

import org.springframework.stereotype.Service;

@Service
public class powerClassifierImpl implements powerClassifier {

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
