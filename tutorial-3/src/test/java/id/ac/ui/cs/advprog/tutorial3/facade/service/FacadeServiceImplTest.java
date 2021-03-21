package id.ac.ui.cs.advprog.tutorial3.facade.service;


import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.AlphaCodex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.RunicCodex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.CodexTranslator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacadeServiceImplTest {

    @Mock
    private AlphaCodex alphaCodex;

    @Mock
    private RunicCodex runicCodex;

    @Mock
    private CodexTranslator codexTranslator;

    @InjectMocks
    FacadeServiceImpl facadeService;



    @Test
    public void testWhenEncodeDummy () {
        facadeService.setRequestType("encode");
        facadeService.setRequestValue("dummy");

        String value = facadeService.getRequestValue();

        String actual = facadeService.encode(value);

        assertEquals("VH#__", actual);
    }

    @Test
    public void testWhenDecodeDummy () {

        facadeService.setRequestType("decode");
        facadeService.setRequestValue("dummy");

        String value = facadeService.getRequestValue();

        String actual = facadeService.decode(value);

        assertEquals("VH#__", actual);

    }

    @Test
    public void testSetRequestType(){
        facadeService.setRequestType("encode");
        assertTrue(facadeService.isRequestEncode());
    }

    @Test
    public void testSetRequestValueAndGetRequestValue() {
        facadeService.setRequestValue("dummy");
        assertEquals("dummy", facadeService.getRequestValue());
    }

    @Test
    public void testIsRequestEncode(){
        facadeService.setRequestValue("decode");
        assertFalse(facadeService.isRequestEncode());
    }


}
