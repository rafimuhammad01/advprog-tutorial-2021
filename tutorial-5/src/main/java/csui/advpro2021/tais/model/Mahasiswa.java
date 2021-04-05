package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mahasiswa")
@Data
@NoArgsConstructor
public class Mahasiswa {

    @Id
    @Column(name = "npm", updatable = false, nullable = false)
    private String npm;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "ipk")
    private String ipk;

    @Column(name = "no_telp")
    private String noTelp;

    @ManyToOne
    @JoinColumn(name="mata_kuliah_id")
    @JsonIgnore
    private MataKuliah mataKuliah;

    @OneToMany(mappedBy="asdos")
    private List<Log> logs;

    @Column
    private String mataKuliahID;

    public Mahasiswa(String npm, String nama, String email, String ipk, String noTelp) {
        this.npm = npm;
        this.nama = nama;
        this.email = email;
        this.ipk = ipk;
        this.noTelp = noTelp;
        this.logs = new ArrayList<>();
        this.mataKuliahID = "";
    }
}
