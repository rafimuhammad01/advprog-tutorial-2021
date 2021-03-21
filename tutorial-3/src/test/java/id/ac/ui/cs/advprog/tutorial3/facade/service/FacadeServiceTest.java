package id.ac.ui.cs.advprog.tutorial3.facade.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FacadeServiceTest {
    private Class<?> facadeServiceClass;

    @InjectMocks
    private FacadeServiceImpl facadeService;

    @BeforeEach
    public void setup() throws Exception {
        facadeServiceClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.facade.service.FacadeServiceImpl");
    }

    @Test
    public void testFacadeServiceHasEncodeMethod() throws Exception {
        Method encode = facadeServiceClass.getDeclaredMethod("encode", String.class);
        int methodModifiers = encode.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testFacadeServiceEncodeCorrectlyImplemented() {
        // TODO: ganti assertion output untuk menguji hasil
        facadeService.setRequestType("encode");
        facadeService.setRequestValue("Safira and I went to a blacksmith to forge our sword");

        String result = facadeService.encode("Safira and I went to a blacksmith to forge our sword");
        assertEquals("!|G*^ccD^#m:M%deeq-!]}y!!|BiZAvS@!%N__u<&yZ!DF@?F)_w", result);
    }

    @Test
    public void testFacadeServiceHasDecodeMethod() throws Exception {
        Method decode = facadeServiceClass.getDeclaredMethod("decode", String.class);
        int methodModifiers = decode.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testFacadeServiceDecodeCorrectlyImplemented() {
        // TODO: ganti input dan assertion output untuk menguji hasil decode
        facadeService.setRequestType("decode");
        facadeService.setRequestValue("!|G*^ccD^#m:M%deeq-!]}y!!|BiZAvS@!%N__u<&yZ!DF@?F)_w");

        String result = facadeService.decode("!|G*^ccD^#m:M%deeq-!]}y!!|BiZAvS@!%N__u<&yZ!DF@?F)_w");
        assertEquals("Safira and I went to a blacksmith to forge our sword", result);
    }

    @Test
    public void testFacadeServiceHasSetRequestTypeMethod() throws Exception {
        Method setRequestType = facadeServiceClass.getDeclaredMethod("setRequestType", String.class);
        int methodModifiers = setRequestType.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testFacadeServiceHasSetRequestValueMethod() throws Exception {
        Method setRequestValue = facadeServiceClass.getDeclaredMethod("setRequestValue", String.class);
        int methodModifiers = setRequestValue.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testFacadeServiceHasIsRequestEncodeMethod() throws Exception {
        Method isRequestEncode = facadeServiceClass.getDeclaredMethod("isRequestEncode");
        int methodModifiers = isRequestEncode.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testFacadeServiceHasGetRequestValueMethod() throws Exception {
        Method getRequestValue = facadeServiceClass.getDeclaredMethod("getRequestValue");
        int methodModifiers = getRequestValue.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }
}
