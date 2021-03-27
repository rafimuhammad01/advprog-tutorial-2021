package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;

public class InuzumaRamen extends Menu {
    //Ingridients:
    //Noodle: Ramen
    //Meat: Pork
    //Topping: Boiled Egg
    //Flavor: Spicy
    public InuzumaRamen(String name){
        super(name);
        setNoodle(new Ramen());
        setMeat(new Pork());
        setTopping(new BoiledEgg());
        setFlavor(new Spicy());
    }
}