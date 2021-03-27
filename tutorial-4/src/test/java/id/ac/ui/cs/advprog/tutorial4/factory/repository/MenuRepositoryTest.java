package id.ac.ui.cs.advprog.tutorial4.factory.repository;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamenTest;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuRepositoryTest {

    private MenuRepository menuRepository;

    @Mock
    private List<Menu> menus;

    private Menu sampleMenu;

    @BeforeEach
    public void setUp() {
        menuRepository = new MenuRepository();
        menus = new ArrayList<>();
        sampleMenu = new LiyuanSoba("Indomi");
        menuRepository.add(sampleMenu);
    }

    @Test
    public void testGetMenus() {
        ReflectionTestUtils.setField(menuRepository, "list", menus);
        List<Menu> accuiredMenus = menuRepository.getMenus();
        System.out.println(menus);
        assertThat(accuiredMenus).isEqualTo(new ArrayList<>(menus));
    }

    @Test
    public void testAdd() {
        ReflectionTestUtils.setField(menuRepository, "list", menus);

        Menu newMenu = new InuzumaRamen("dummy");
        menuRepository.add(newMenu);

        assertEquals(1, menuRepository.getMenus().size());

    }

}
