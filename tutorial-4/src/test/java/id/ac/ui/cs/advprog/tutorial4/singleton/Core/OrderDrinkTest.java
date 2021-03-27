package id.ac.ui.cs.advprog.tutorial4.singleton.Core;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderDrinkTest {

    @Mock
    private OrderDrink orderDrink;


    @Test
    public void testGetInstance() {
        //create order drink instance
        OrderDrink orderDrink = OrderDrink.getInstance();


        //order drink get instance
        OrderDrink orderDrinkgetInstance = OrderDrink.getInstance();

        //must be equal
        assertEquals(orderDrink, orderDrinkgetInstance);
    }

    @Test
    public void testGetDrink() {
        OrderDrink test = OrderDrink.getInstance();
        ReflectionTestUtils.setField(test, "drink", "kopi"); //for changing private value

        assertEquals("kopi", test.getDrink());
    }


    @Test
    public void testSetDrink() {
        OrderDrink test = OrderDrink.getInstance();
        test.setDrink("kopi");

        ReflectionTestUtils.getField(test, "drink");

        assertEquals("kopi", ReflectionTestUtils.getField(test, "drink"));
    }

    @Test
    public void testToString() {

        OrderDrink test = OrderDrink.getInstance();
        ReflectionTestUtils.setField(test, "drink", "kopi"); //for changing private value

        assertEquals("kopi", test.toString());

    }
}
