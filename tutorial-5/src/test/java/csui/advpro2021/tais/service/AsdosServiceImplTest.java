package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AsdosServiceImplTest {
    @Mock
    private MahasiswaRepository mahasiswaRepository;

    @Mock
    private MataKuliahRepository mataKuliahRepository;

    @Mock
    private MataKuliahService mataKuliahService;

    @Mock
    private MahasiswaService mahasiswaService;

    @Mock
    private LogService logService;

    @InjectMocks
    private AsdosServiceImpl asdosService;

    private Mahasiswa asdos;

    private MataKuliah matkul;

    private Log log;

    private Log log2;

    @BeforeEach
    public void setUp(){
        asdos = new Mahasiswa();
        asdos.setNpm("1906192052");
        asdos.setNama("Maung Meong");
        asdos.setEmail("maung@cs.ui.ac.id");
        asdos.setIpk("4");
        asdos.setNoTelp("081317691718");
        asdos.setLogs(new ArrayList<>());

        matkul = new MataKuliah();
        matkul.setKodeMatkul("ADVPROG");
        matkul.setNama("Advanced Programming");
        matkul.setProdi("Ilmu Komputer");
        matkul.setAsdos(new ArrayList<>());

        log = new Log();
        log.setIdLog("1");
        log.setStart(new Date());
        log.setEnd(new Date());
        log.setDeskripsi("Demo Advanced Programming");

        log2 = new Log();
        log2.setIdLog("2");
        log2.setStart(new Date());
        log2.setEnd(new Date());
        log2.setDeskripsi("Demo Advanced Programming");


    }

    @Test
    public void testServiceAddAsdos(){
        lenient().when(mataKuliahService.getMataKuliah(matkul.getKodeMatkul())).thenReturn(matkul);
        lenient().when(mahasiswaService.getMahasiswaByNPM(asdos.getNpm())).thenReturn(asdos);

        asdosService.addAsdos(matkul.getKodeMatkul(), asdos);
        assertEquals(false, matkul.getAsdos().isEmpty());

    }

    @Test
    public void testServiceAddLog(){
        lenient().when(mahasiswaService.getMahasiswaByNPM(asdos.getNpm())).thenReturn(asdos);
        lenient().when(logService.createLog(log)).thenReturn(log);
        lenient().when(logService.getLogByID(log.getIdLog())).thenReturn(log);


        asdosService.addLog(asdos.getNpm(), log);
        assertFalse(asdos.getLogs().isEmpty());

    }

    @Test
    public void testServiceGenerateLaporan(){
        asdos.getLogs().add(log);
        asdos.getLogs().add(log2);

        lenient().when(mahasiswaService.getMahasiswaByNPM(asdos.getNpm())).thenReturn(asdos);
        List<LaporanPembayaran> laporan =  asdosService.generateLaporan(asdos.getNpm());
        assertFalse(laporan.isEmpty());

    }
}
