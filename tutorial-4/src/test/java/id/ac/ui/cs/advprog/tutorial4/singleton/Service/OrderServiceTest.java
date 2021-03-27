package id.ac.ui.cs.advprog.tutorial4.singleton.Service;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import id.ac.ui.cs.advprog.tutorial4.singleton.service.OrderService;
import id.ac.ui.cs.advprog.tutorial4.singleton.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

    @Mock
    OrderDrink orderDrink;

    @Test
    public void testOrderADrink() {
        orderService.orderADrink("kopi");
        assertEquals(OrderDrink.getInstance(), ReflectionTestUtils.getField(orderService, "orderDrink"));
    }

    @Test
    public void testGetDrink() {
        orderService.orderADrink("kopi");
        assertEquals(OrderDrink.getInstance(), orderService.getDrink());

    }

    @Test
    public void testOrderAFood() {
        orderService.orderAFood("indomi");
        assertEquals(OrderFood.getInstance(), ReflectionTestUtils.getField(orderService, "orderFood"));
    }

    @Test
    public void testGetFood() {
        orderService.orderAFood("indomi");
        assertEquals(OrderFood.getInstance(), orderService.getFood());

    }




}
