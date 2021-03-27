package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class MondoUdon extends Menu {
    //Ingridients:
    //Noodle: Udon
    //Meat: Chicken
    //Topping: Cheese
    //Flavor: Salty
    public MondoUdon(String name){
        super(name);
        setNoodle(new Udon());
        setMeat(new Chicken());
        setTopping(new Cheese());
        setFlavor(new Salty());
    }
}