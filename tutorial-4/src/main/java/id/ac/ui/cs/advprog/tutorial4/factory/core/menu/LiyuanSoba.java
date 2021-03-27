package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Mushroom;

public class LiyuanSoba extends Menu {
    //Ingridients:
    //Noodle: Soba
    //Meat: Beef
    //Topping: Mushroom
    //Flavor: Sweet
    public LiyuanSoba(String name){
        super(name);
        setNoodle(new Soba());
        setMeat(new Beef());
        setTopping(new Mushroom());
        setFlavor(new Sweet());
    }
}