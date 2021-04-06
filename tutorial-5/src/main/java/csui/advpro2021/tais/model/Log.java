package csui.advpro2021.tais.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
@Data
@NoArgsConstructor
public class Log {
    @Id
    @Column(name = "id_log", updatable = false, nullable = false)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idLog;


    @Column(name = "startTime")
    private Date start;

    @Column(name = "endTime")
    private Date end;


    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name="asdos_id")
    @JsonIgnore
    private Mahasiswa asdos;


    public Log(String idLog, Date start, Date end, String deskripsi, Mahasiswa asdos) {
        this.idLog = idLog;
        this.start = start;
        this.end = end;
        this.deskripsi = deskripsi;
        this.asdos = asdos;
    }
}
