package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Log;
import org.springframework.stereotype.Service;


public interface LogService {
    Log createLog(Log log);

    Log getLogByID(String idLog);

    Iterable<Log> getListLog();

    Log updateLog(String npm, String idLog, Log log);

    void deleteLogByIdLog(String idLog);
}
