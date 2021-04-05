package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MataKuliahServiceImplTest {
    @Mock
    private MataKuliahRepository mataKuliahRepository;

    @InjectMocks
    private MataKuliahServiceImpl mataKuliahService;

    private MataKuliah matkul;

    @BeforeEach
    public void setUp() {
        matkul = new MataKuliah();
        matkul.setKodeMatkul("ADVPROG");
        matkul.setNama("Advanced Programming");
        matkul.setProdi("Ilmu Komputer");
        matkul.setAsdos(new ArrayList<>());
    }

    @Test
    void testServiceGetListMataKuliah() {
        Iterable<MataKuliah> listMataKuliah = mataKuliahRepository.findAll();
        lenient().when(mataKuliahService.getListMataKuliah()).thenReturn(listMataKuliah);
        Iterable<MataKuliah> listMataKuliahResult = mataKuliahService.getListMataKuliah();
        Assertions.assertIterableEquals(listMataKuliah, listMataKuliahResult);
    }

    @Test
    void testServiceGetMataKuliah() {
        lenient().when(mataKuliahService.getMataKuliah(matkul.getKodeMatkul())).thenReturn(matkul);
        MataKuliah resultMatkul = mataKuliahService.getMataKuliah(matkul.getKodeMatkul());
        Assertions.assertEquals(matkul.getKodeMatkul(), resultMatkul.getKodeMatkul());
    }

    @Test
    void testServiceCreateMataKuliah() {
        lenient().when(mataKuliahService.createMataKuliah(matkul)).thenReturn(matkul);
        MataKuliah resultMatkul = mataKuliahService.createMataKuliah(matkul);
        Assertions.assertEquals(matkul.getKodeMatkul(), resultMatkul.getKodeMatkul());
    }

    @Test
    void testServiceUpdateMataKuliah() {
        mataKuliahService.createMataKuliah(matkul);
        String namaMatkul = "ADV125YIHA";
        matkul.setNama(namaMatkul);
        MataKuliah expectedMatkul = matkul;
        expectedMatkul.setNama(namaMatkul);
        MataKuliah resultMatkul = mataKuliahService.updateMataKuliah(matkul.getKodeMatkul(), matkul);
        Assertions.assertEquals(expectedMatkul.getNama(), resultMatkul.getNama());
    }

    @Test
    void testServiceDeleteMataKuliah() {

        lenient().when(mataKuliahService.getMataKuliah(matkul.getKodeMatkul())).thenReturn(matkul);
        mataKuliahService.createMataKuliah(matkul);
        mataKuliahService.deleteMataKuliah(matkul.getKodeMatkul());

        lenient().when(mataKuliahService.getMataKuliah(matkul.getKodeMatkul())).thenReturn(null);
        Assertions.assertEquals(null, mataKuliahService.getMataKuliah(matkul.getKodeMatkul()));
    }
}
