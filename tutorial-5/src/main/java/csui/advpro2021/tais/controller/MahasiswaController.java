package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.service.AsdosService;
import csui.advpro2021.tais.service.LogService;
import csui.advpro2021.tais.service.LogServiceImpl;
import csui.advpro2021.tais.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mahasiswa")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private AsdosService asdosService;

    @Autowired
    private LogService logService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.ok(mahasiswaService.createMahasiswa(mahasiswa));
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Mahasiswa>> getListMahasiswa() {
        return ResponseEntity.ok(mahasiswaService.getListMahasiswa());
    }

    @GetMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getMahasiswa(@PathVariable(value = "npm") String npm) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNPM(npm);
        if (mahasiswa == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(mahasiswa);
    }

    @PutMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateMahasiswa(@PathVariable(value = "npm") String npm, @RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.ok(mahasiswaService.updateMahasiswa(npm, mahasiswa));
    }

    @DeleteMapping(path = "/{npm}", produces = {"application/json"})
    public ResponseEntity deleteMahasiswa(@PathVariable(value = "npm") String npm) {
        mahasiswaService.deleteMahasiswaByNPM(npm);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addLog(@PathVariable(value = "npm") String npm, @RequestBody Log log) {
        Mahasiswa res = asdosService.addLog(npm, log);
        return ResponseEntity.ok(res);
    }

    @PutMapping(path = "/{npm}/{logID}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateLog(@PathVariable(value = "npm") String npm, @PathVariable(value = "logID") String logID, @RequestBody Log log) {
        logService.updateLog(npm, logID, log);
        return ResponseEntity.ok(mahasiswaService.getMahasiswaByNPM(npm));
    }

    @DeleteMapping(path = "/{npm}/{logID}", produces = {"application/json"})
    public ResponseEntity deleteLog(@PathVariable(value = "npm") String npm, @PathVariable(value = "logID") String logID) {
        for (Log i : mahasiswaService.getMahasiswaByNPM(npm).getLogs()) {
            if (i.getIdLog().equals(logID)) {
                logService.deleteLogByIdLog(logID);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/laporan-pembayaran/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getLaporanPembayaran(@PathVariable(value = "npm") String npm) {
        List<LaporanPembayaran> LaporanPembayaran = asdosService.generateLaporan(npm);
        return ResponseEntity.ok(LaporanPembayaran);
    }
}
