package id.ac.ui.cs.advprog.tutorial4.singleton.Core;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderFoodTest {
    
    @Test
    public void testGetInstance() {
        //create order drink instance
        OrderFood orderFood = OrderFood.getInstance();


        //order drink get instance
       OrderFood orderFoodgetInstance = OrderFood.getInstance();

        //must be equal
        assertEquals(orderFood, orderFoodgetInstance);
    }

    @Test
    public void testGetDrink() {
        OrderFood test = OrderFood.getInstance();
        ReflectionTestUtils.setField(test, "food", "indomi"); //for changing private value

        assertEquals("indomi", test.getFood());
    }


    @Test
    public void testSetDrink() {
        OrderFood test = OrderFood.getInstance();
        test.setFood("indomi");


        assertEquals("indomi", ReflectionTestUtils.getField(test, "food"));
    }

    @Test
    public void testToString() {

        OrderFood test = OrderFood.getInstance();
        ReflectionTestUtils.setField(test, "food", "indomi"); //for changing private value

        assertEquals("indomi", test.toString());

    }

}
