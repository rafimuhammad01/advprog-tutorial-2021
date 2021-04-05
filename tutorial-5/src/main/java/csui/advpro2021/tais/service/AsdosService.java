package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;

import java.util.List;

public interface AsdosService {

    MataKuliah addAsdos(String kodeMatkul, Mahasiswa asdos);

    Mahasiswa addLog(String npm, Log log);

    List<LaporanPembayaran> generateLaporan(String npm);
}
