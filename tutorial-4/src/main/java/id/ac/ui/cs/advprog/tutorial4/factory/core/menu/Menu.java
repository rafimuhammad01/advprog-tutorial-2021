package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class Menu {
    private String name;
    private Noodle noodle;
    private Meat meat;
    private Topping topping;
    private Flavor flavor;

    //To Do : Complete Me
    //Silahkan tambahkan parameter jika dibutuhkan
    public Menu(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Noodle getNoodle() {
        return noodle;
    }

    public Meat getMeat() {
        return meat;
    }

    public Topping getTopping() {
        return topping;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setNoodle(Noodle noodle) {
        this.noodle = noodle;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }
}