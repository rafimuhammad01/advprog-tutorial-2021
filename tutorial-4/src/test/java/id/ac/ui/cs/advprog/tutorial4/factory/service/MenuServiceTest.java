package id.ac.ui.cs.advprog.tutorial4.factory.service;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamenTest;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import id.ac.ui.cs.advprog.tutorial4.factory.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class MenuServiceTest {
    private Class<?> menuServiceClass;

    @Spy
    MenuRepository menuRepository = new MenuRepository();


    @InjectMocks
    MenuService menuService = new MenuServiceImpl();


    @BeforeEach
    public void setup() throws Exception{
        menuServiceClass = Class.forName(
          "id.ac.ui.cs.advprog.tutorial4.factory.service.MenuServiceImpl"
        );
    }


    @Test
    public void testHasGetMenus() throws Exception {
        Method getMenus = menuServiceClass.getDeclaredMethod("getMenus");

        int methodModifiers = getMenus.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));

        ParameterizedType pt = (ParameterizedType) getMenus.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(Menu.class));
    }

    @Test
    public void testGetMenusReturnValue() {
        // Empty Repo
        ReflectionTestUtils.setField(menuService, "repo", menuRepository);


        // Adding menus
        menuRepository.add(new InuzumaRamen("test"));
        menuRepository.add(new LiyuanSoba("test"));

        // Check if equals
        assertEquals(2, menuService.getMenus().size());


    }


    @Test
    public void testHasCreateMenu() throws Exception {
        Method createMenus = menuServiceClass.getDeclaredMethod("createMenu", String.class, String.class);

        int methodModifiers = createMenus.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
        
    }
    
    @Test
    public void testCreatingMenu() {
        // Empty Repo
        ReflectionTestUtils.setField(menuService, "repo", menuRepository);

        // Create Menu
        menuService.createMenu("Dummy", "LiyuanSoba");
        assertEquals(1, menuService.getMenus().size());
        
    }


}
