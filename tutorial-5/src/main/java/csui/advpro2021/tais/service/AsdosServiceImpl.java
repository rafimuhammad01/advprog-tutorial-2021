package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Service
public class AsdosServiceImpl implements AsdosService{

    @Autowired
    private MataKuliahService mataKuliahService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private LogService logService;

    @Override
    public MataKuliah addAsdos(String kodeMatkul, Mahasiswa asdos) {
        MataKuliah matkul = mataKuliahService.getMataKuliah(kodeMatkul);

        // Change foreign key data mahasiswa
        Mahasiswa newMahasiswa = mahasiswaService.getMahasiswaByNPM(asdos.getNpm());
        newMahasiswa.setMataKuliah(matkul);
        //newMahasiswa.setMataKuliahID(matkul.getKodeMatkul());
        mahasiswaService.updateMahasiswa(asdos.getNpm(), newMahasiswa);

        //Change foreign key data matkul
        MataKuliah newMatkul = matkul.addMahasiswa(asdos);

        return mataKuliahService.updateMataKuliah(kodeMatkul, newMatkul);

    }

    @Override
    public Mahasiswa addLog(String npm, Log log) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNPM(npm);
        Log createdLog = logService.createLog(log);

        // Change foreign key log data;
        Log newLog = logService.getLogByID(createdLog.getIdLog());
        newLog.setAsdos(mahasiswa);
        logService.updateLog(npm, newLog.getIdLog(), newLog);

        // Change foreign key mahasiswa data
        mahasiswa.getLogs().add(newLog);

        return mahasiswaService.updateMahasiswa(npm, mahasiswa);
    }

    @Override
    public List<LaporanPembayaran> generateLaporan(String npm) {
        Calendar cal = Calendar.getInstance();
        Mahasiswa  mahasiswa  = mahasiswaService.getMahasiswaByNPM(npm);
        Map<String, LaporanPembayaran> laporanPembayarans = new HashMap<>();
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (Log i : mahasiswa.getLogs()) {
            cal.setTime(i.getStart());
            int startMonth = cal.get(Calendar.MONTH);

            cal.setTime(i.getEnd());
            int endMonth = cal.get(Calendar.MONTH);

            if (startMonth == endMonth) {
                String month = monthNames[startMonth];
                if (laporanPembayarans.get(month) == null) {
                    long diff = Math.abs(i.getEnd().getTime() - i.getStart().getTime())/(60*60*1000);
                    int pembayaran = (int)diff*350;
                    LaporanPembayaran laporanPembayaran = new LaporanPembayaran(month, (int)diff, pembayaran);
                    laporanPembayarans.put(month, laporanPembayaran);
                } else {
                    long diff = Math.abs(i.getEnd().getTime() - i.getStart().getTime())/(60*60*1000);
                    ((LaporanPembayaran) laporanPembayarans.get(month)).jamKerja += diff;
                    ((LaporanPembayaran) laporanPembayarans.get(month)).pembayaran = ((LaporanPembayaran) laporanPembayarans.get(month)).jamKerja *350;

                }
            } /*else {
                String startMonthString = monthNames[startMonth];
                String endMonthString = monthNames[endMonth];

                // for start Month
                if (laporanPembayarans.get(startMonthString) == null) {

                    //Get Last Day of the Month
                    LocalDate convertedDate = i.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
                    Date date = Date.from(convertedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                    // Get Diff
                    long diff = Math.abs(i.getStart().getTime() - date.getTime());
                    int jamKerja = (int)TimeUnit.DAYS.convert(diff, TimeUnit.HOURS);
                    int pembayaran = jamKerja*350;
                    LaporanPembayaran laporanPembayaran = new LaporanPembayaran(startMonthString, jamKerja, pembayaran);
                    laporanPembayarans.put(startMonthString, laporanPembayaran);

                } else if (laporanPembayarans.get(startMonthString) != null) {

                    // Get Last Day of the Month
                    LocalDate convertedDate = i.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
                    Date date = Date.from(convertedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                    // Get Diff
                    long diff = Math.abs(i.getStart().getTime() - date.getTime());
                    int jamKerja = (int)TimeUnit.DAYS.convert(diff, TimeUnit.HOURS);
                    ((LaporanPembayaran) laporanPembayarans.get(startMonthString)).jamKerja += jamKerja;
                    ((LaporanPembayaran) laporanPembayarans.get(startMonthString)).pembayaran = jamKerja*350;
                }

                // For endMonth

                if (laporanPembayarans.get(endMonthString) == null){
                    //Get Last Day of the Month
                    LocalDate convertedDate = i.getEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
                    Date date = Date.from(convertedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                    // Get Diff
                    long diff = Math.abs(i.getEnd().getTime() - date.getTime());
                    int jamKerja = (int)TimeUnit.DAYS.convert(diff, TimeUnit.HOURS);
                    int pembayaran = jamKerja*350;
                    LaporanPembayaran laporanPembayaran = new LaporanPembayaran(startMonthString, jamKerja, pembayaran);
                    laporanPembayarans.put(startMonthString, laporanPembayaran);
                }

            }
            */
        }

        List<LaporanPembayaran> laporanPembayaranList = new ArrayList<>();
        for (String key : laporanPembayarans.keySet()) {

            laporanPembayaranList.add(laporanPembayarans.get(key));
        }

        return laporanPembayaranList;
    }

}
