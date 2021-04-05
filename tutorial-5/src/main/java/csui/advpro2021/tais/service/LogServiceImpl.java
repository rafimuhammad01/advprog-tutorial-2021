package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private MahasiswaService mahasiswaService;

    @Override
    public Log createLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log getLogByID(String idLog) {
        return logRepository.findByIdLog(idLog);
    }

    @Override
    public Iterable<Log> getListLog() {
        return logRepository.findAll();
    }

    @Override
    public Log updateLog(String npm, String idLog, Log log) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNPM(npm);
        Log newLog = null;
        for (Log i : mahasiswa.getLogs()) {
            if (i.getIdLog() == idLog) {
                System.out.println("newLog pertama");
                i.setAsdos(log.getAsdos());
                i.setDeskripsi(log.getDeskripsi());
                i.setEnd(log.getEnd());
                i.setStart(log.getStart());
                newLog = i;
            }
        }

        if (newLog == null) {
            System.out.println("newLog kedua");
            newLog = logRepository.findByIdLog(idLog);
            newLog.setDeskripsi(log.getDeskripsi());
            newLog.setEnd(log.getEnd());
            newLog.setStart(log.getStart());
        }
        logRepository.save(newLog);
        return newLog;
    }

    @Override
    public void deleteLogByIdLog(String idLog) {
        logRepository.deleteById(idLog);
    }
}
