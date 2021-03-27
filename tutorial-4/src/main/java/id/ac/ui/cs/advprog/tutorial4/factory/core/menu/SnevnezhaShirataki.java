package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower;

public class SnevnezhaShirataki extends Menu {
    //Ingridients:
    //Noodle: Shirataki
    //Meat: Fish
    //Topping: Flower
    //Flavor: Umami
    public SnevnezhaShirataki(String name){
        super(name);
        setNoodle(new Shirataki());
        setMeat(new Fish());
        setTopping(new Flower());
        setFlavor(new Umami());
    }
}