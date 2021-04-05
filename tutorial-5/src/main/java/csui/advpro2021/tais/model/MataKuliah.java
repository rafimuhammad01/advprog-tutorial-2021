package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mata_kuliah")
@Data
@NoArgsConstructor
public class MataKuliah {
    @Id
    @Column(name = "kode_matkul", updatable = false)
    private String kodeMatkul;

    @Column(name = "nama_matkul")
    private String nama;

    @Column(name = "prodi")
    private String prodi;

    @OneToMany(mappedBy = "mataKuliah")
    private List<Mahasiswa> asdos;

    public MataKuliah(String kodeMatkul, String nama, String prodi) {
        this.kodeMatkul = kodeMatkul;
        this.nama = nama;
        this.prodi = prodi;
        this.asdos = new ArrayList<>();
    }

    public MataKuliah addMahasiswa(Mahasiswa mahasiswa) {
        this.asdos.add(mahasiswa);
        return this;
    }
}
