package csui.advpro2021.tais.repository;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, String> {
    Log findByIdLog(String idLog);
}
