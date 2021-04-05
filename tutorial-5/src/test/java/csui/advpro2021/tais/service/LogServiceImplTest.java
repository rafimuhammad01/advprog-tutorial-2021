package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.LogRepository;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class LogServiceImplTest {

    @Mock
    private LogRepository logRepository;

    @Mock
    private MahasiswaService mahasiswaService;

    @InjectMocks
    private LogServiceImpl logService;

    private Mahasiswa asdos;

    private MataKuliah matkul;

    private Log log;

    @BeforeEach
    void setUp() {
        asdos = new Mahasiswa();
        asdos.setNpm("1906192052");
        asdos.setNama("Maung Meong");
        asdos.setEmail("maung@cs.ui.ac.id");
        asdos.setIpk("4");
        asdos.setNoTelp("081317691718");
        asdos.setLogs(new ArrayList<>());

        log = new Log();
        log.setIdLog("1");
        log.setStart(new Date());
        log.setEnd(new Date());
        log.setDeskripsi("Demo Advanced Programming");
    }

    @Test
    public void testServiceCreateLog(){
        lenient().when(logService.createLog(log)).thenReturn(log);
    }

    @Test
    public void testServiceGetListLogs(){
        Iterable<Log> listLogs = logRepository.findAll();
        lenient().when(logService.getListLog()).thenReturn(listLogs);
        Iterable<Log> listLogResult = logService.getListLog();
        Assertions.assertIterableEquals(listLogs, listLogResult);
    }

    @Test
    public void testServiceGetLogByID(){
        lenient().when(logService.getLogByID("1")).thenReturn(log);
        Log resultLog = logService.getLogByID(log.getIdLog());
        assertEquals(log.getIdLog(), resultLog.getIdLog());
    }

    @Test
    public void testServiceDeleteLog(){
        logService.createLog(log);
        lenient().when(logService.getLogByID("1")).thenReturn(log);
        logService.deleteLogByIdLog("1");
        lenient().when(logService.getLogByID("1")).thenReturn(null);
        assertEquals(null, logService.getLogByID("1"));
    }

    @Test
    public void testServiceUpdateLogInMahasiswa(){
        logService.createLog(log);
        asdos.getLogs().add(log);

        String currentDeskripsiValue = log.getDeskripsi();
        //Change Deskripsi from Demo Advanced Programming to Demo tutorial-2 Advanced Programming
        log.setDeskripsi("Demo tutorial-2 Advanced Programming");

        lenient().when(mahasiswaService.getMahasiswaByNPM(asdos.getNpm())).thenReturn(asdos);
        lenient().when(logRepository.findByIdLog(log.getIdLog())).thenReturn(log);


        lenient().when(logService.updateLog(asdos.getNpm(),log.getIdLog(), log)).thenReturn(log);
        Log resultLog = logService.updateLog(asdos.getNpm(),log.getIdLog(), log);

        assertNotEquals(resultLog.getDeskripsi(), currentDeskripsiValue);
        assertEquals(resultLog.getStart(), log.getStart());


    }

    @Test
    public void testServiceUpdateLogInRepository(){
        logService.createLog(log);

        String currentDeskripsiValue = log.getDeskripsi();
        //Change Deskripsi from Demo Advanced Programming to Demo tutorial-2 Advanced Programming
        log.setDeskripsi("Demo tutorial-2 Advanced Programming");

        lenient().when(mahasiswaService.getMahasiswaByNPM(asdos.getNpm())).thenReturn(asdos);
        lenient().when(logRepository.findByIdLog(log.getIdLog())).thenReturn(log);


        lenient().when(logService.updateLog(asdos.getNpm(),log.getIdLog(), log)).thenReturn(log);
        Log resultLog = logService.updateLog(asdos.getNpm(),log.getIdLog(), log);

        assertNotEquals(resultLog.getDeskripsi(), currentDeskripsiValue);
        assertEquals(resultLog.getStart(), log.getStart());


    }
}
