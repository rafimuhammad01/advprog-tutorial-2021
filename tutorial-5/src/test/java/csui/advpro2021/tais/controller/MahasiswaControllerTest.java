package csui.advpro2021.tais.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = MahasiswaController.class)
public class MahasiswaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LogServiceImpl logService;

    @MockBean
    private AsdosServiceImpl asdosService;

    @MockBean
    private MahasiswaServiceImpl mahasiswaService;

    private Mahasiswa mahasiswa;

    private List<LaporanPembayaran> laporanPembayaran;

    private Log log;

    @BeforeEach
    public void setUp(){
        mahasiswa = new Mahasiswa("1906192052", "Maung Meong", "maung@cs.ui.ac.id", "4",
                "081317691718");
        log = new Log("1", new Date(), new Date(), "Demo Adpro", mahasiswa);
        laporanPembayaran = new ArrayList<>();
        laporanPembayaran.add(new LaporanPembayaran("January", 1, 350));

    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void testControllerPostMahasiswa() throws Exception{

        when(mahasiswaService.createMahasiswa(mahasiswa)).thenReturn(mahasiswa);

        mvc.perform(post("/mahasiswa")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(mahasiswa)))
                .andExpect(jsonPath("$.npm").value("1906192052"));
    }

    @Test
    public void testControllerGetListMahasiswa() throws Exception{

        Iterable<Mahasiswa> listMahasiswa = Arrays.asList(mahasiswa);
        when(mahasiswaService.getListMahasiswa()).thenReturn(listMahasiswa);

        mvc.perform(get("/mahasiswa").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].npm").value("1906192052"));
    }

    @Test
    public void testControllerGetMahasiswaByNpm() throws Exception{

        when(mahasiswaService.getMahasiswaByNPM("1906192052")).thenReturn(mahasiswa);
        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value("Maung Meong"));
    }

    @Test
    public void testControllerGetNonExistMahasiswa() throws Exception{
        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testControllerUpdateMahasiswa() throws Exception{

        mahasiswaService.createMahasiswa(mahasiswa);

        //Update mahasiswa object nama
        mahasiswa.setNama("Quanta Quantul");

        when(mahasiswaService.updateMahasiswa(mahasiswa.getNpm(), mahasiswa)).thenReturn(mahasiswa);

        mvc.perform(put("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(mahasiswa)))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value("Quanta Quantul"));
    }

    @Test
    public void testControllerDeleteMahasiswa() throws Exception{
        mahasiswaService.createMahasiswa(mahasiswa);
        mvc.perform(delete("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testControllerPostLog() throws Exception{
        mahasiswaService.createMahasiswa(mahasiswa);
        when(asdosService.addLog(Mockito.any(), Mockito.any())).thenReturn(mahasiswa);

        mvc.perform(post("/mahasiswa/1906192052")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(log)))
                .andExpect(jsonPath("$.npm").value("1906192052"));
    }

    @Test
    public void testControllerGenerateLaporanPembayaran() throws Exception{
        mahasiswaService.createMahasiswa(mahasiswa);
        when(asdosService.generateLaporan(mahasiswa.getNpm())).thenReturn(laporanPembayaran);

        mvc.perform(get("/mahasiswa/laporan-pembayaran/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].jamKerja").value("1"));
    }

    @Test
    public void testControllerDeleteLog() throws Exception{
        mahasiswaService.createMahasiswa(mahasiswa);
        mahasiswa.getLogs().add(log);
        when(mahasiswaService.getMahasiswaByNPM(mahasiswa.getNpm())).thenReturn(mahasiswa);

        mvc.perform(delete("/mahasiswa/1906192052/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testControllerUpdateLog() throws Exception{

        mahasiswaService.createMahasiswa(mahasiswa);
        mahasiswa.getLogs().add(log);

        //Update mahasiswa object nama
        log.setDeskripsi("Quanta Quantul");

        when(logService.updateLog(mahasiswa.getNpm(), log.getIdLog(), log)).thenReturn(log);
        when(mahasiswaService.getMahasiswaByNPM(mahasiswa.getNpm())).thenReturn(mahasiswa);

        mvc.perform(put("/mahasiswa/1906192052/1").contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(log)))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.logs.[0].deskripsi").value("Quanta Quantul"));
    }
}
