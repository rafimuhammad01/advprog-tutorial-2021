# Tutorial 0

# I Got Transported to Another World and All I Can Do is Code with My Advanced Programming Knowledge

Anda membuka mata di sebuah ruangan yang gelap. Hanya sedikit cahaya, tapi cukup untuk melihat sekitar.

Udara terasa dingin dan begitu tenang. Seolah tidak ada angin yang berhembus.
Ketika anda benar-benar bisa melihat, anda melihat sesosok manusia duduk di ujung jalan. Ia tampak gelisah.

Wajahnya menatap anda penuh harap sambil berjalan mendekat. Ia tampak berjalan melalui
sebuah bayangan tembus pandang, tapi anda dapat mendengar suara langkahnya dengan jelas.

Semakin ia mendekat, semakin jelas suara itu terdengar di telinga anda. Ketika ia
semakin mendekat, informasi seolah masuk melalui kepala anda. Ia lalu memberitahu
anda bahwa ia telah memanggil anda ke sini, sebuah dunia yang benar-benar berbeda dengan yang anda kenal.

Dengan gelisah, ia meminta maaf telah merepotkan anda dan ingin anda membantunya.
Ia memperkenalkan diri sebagai [], sebuah ucapan yang tidak bisa anda pahami.
[] menjelaskan bahwa di dunia paralel ini, ada sebuah bahasa sihir kuno bernama java. Manusia di dunia
ini paham bagaimana menggunakan sihir bernama java ini. Mereka telah membuat banyak hal dengan
java. Bahkan ada yang berhasil membuat sihir web dengan java ini.

Salah satu
yang banyak dipakai oleh manusia dunia ini adalah sihir bernama Spring.Mereka membuat web
untuk membantu keseharian. Guild, tempat berkumpulnya para
adventurer menggunakannya untuk mengatur resource mereka. Namun, di sini lah masalah muncul. Penduduk hanya mampu menggunakannya.
Hasil dari penggunaan memiliki kualitas mantra yang jelek. Susah di maintain dan apabila si perapal sihir mati,
tidak ada yang bisa memahami sistem yang telah dibuatnya.
Untuk itu, [] meminta bantuan kepada anda untuk membantu mereka memperbaiki sistem yang mereka miliki.

Anda memahami bahwa sihir di dunia ini adalah program di dunia asal anda.
Mantra adalah kode dan hasil sihir adalah aplikasi. Dengan pemahaman
Advanced Programming yang anda miliki anda bersedia membantu. Memulai
perjalanan anda di dunia lain dengan pemahaman yang anda miliki...

## Magic of Spring

Sayangnya proses pemanggilan membuat ingatan anda kurang
sempurna. Anda paham jika ada pengetahuan
bernama design pattern yang dapat membantu anda di sini. Hanya saja, anda tidak bisa sepenuhnya mengingat pengetahuan itu.
[] mengatakan dengan berjalannya waktu anda akan mendapatkan kembali pengetahuan itu.

Ketika anda diperkenalkan oleh [] kepada seorang guild master, ia memperlihatkan kepada anda spring yang mereka punyai.
Mereka menjelaskan mantra-mantra dasar yang dibutuhkan untuk membuat produk dengan spring.

Aplikasi utama spring terlihat sebagai berikut.

```java
@SpringBootApplication
public class Tutorial0Application {

    public static void main(String[] args) {
        SpringApplication.run(Tutorial0Application.class, args);
    }

}

```

Anda bisa melihat bahwa ada beberapa tanda yang disebut sebagai anotasi. Pada bagian tersebut
anda melihat ada anotasi `@SpringBootAplication` yang menandakan bahwa class tersebut adalah main class
spring yang berfungsi untuk menjalankan aplikasi yang telah dibuat.

Dari serpihan ingatan, anda mengingat bagaimana spring di dunia asal anda bekerja.
Ada controller yang memiliki tugas untuk mengurus request dan response. Kedua, model terkait dengan
logic utama aplikasi. Selanjutnya anda mengenal view untuk menampilkan kepada pengguna.
MVC! Anda merasakan ada sesuatu mengenai kata itu, tapi anda tidak bisa mengingatnya dengan sempurna.

Untuk saat ini anda tahu bahwa controller yang akan berurusan jika ada request ke aplikasi dan memberikan response kepada request tersebut.
Pada bagian controller terlihat seperti berikut.

```java
@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    private String home() {
        return "home";
    }

}
```

Suatu class yang termasuk controller diberikan anotasi `@controller`
Class yang termasuk Controller akan memiliki method-method dengan return type String.
Dalam ingatan, anda paham bahwa string di sini mewakili sebuah nama file .html pada folder resources/templates.
Semua file .html pada folder tersebut akan menjadi tampilan aplikasi.

Pada method home, ia mengembalikan string home, yang merujuk pada home.html pada folder templates.

Method home sendiri memiliki anotasi `@RequestMapping`. Ingatan anda memperlihatkan kepada anda bahwa
anotasi selain dapat diberikan pada class, dapat diberikan kepada method, dan juga attribute.

`RequestMapping` sendiri memiliki fungsi sebagai yang mengatur request yang akan di-handle.
Method apa yang akan diurus(POST, GET, PUT, DELETE, dll) dan juga url apa yang akan di-handle oleh method tersebut.
Method home sendiri memiliki `RequestMethod.GET` dan value "/". Ini berarti akses kepada url path "/" dengan method
GET akan diurus oleh method home ini.

Dengan penjelasan yang anda pahami tersebut, anda ingat penggunaan lebih lanjut dari controller terkait dengan url dan method.

```java
 @RequestMapping(method = RequestMethod.GET, value = "/greet")
    private String greetingsWithRequestParam(@RequestParam("name")String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
```

Anotasi `@RequestParam` adalah untuk menandakan url tersebut dapat ditambahkan "?namaParam=suatu nilai". Hal itu berarti
"/greet" di atas dapat dimasukkan parameter name, menjadi "/greet?name=sesuatu" Nilai di dalam `@ReuqestMapping` merupakan nama param
yang diharapkan ada pada request. Dapat ditambahkan `@RequestMapping(required=false)` untuk membuat nilai variable tersebut
tidak harus ada pada request. Secara default nilai required adalah true. Dengan demikian method greetingsWithRequestParam butuh parameter name
untuk request ke url tersebut. `String name` merupakan nama parameter untuk method tersebut dan tidak harus memiliki nama yang sama dengan
RequestParameter. Ketika anda membuka localhost:8080 anda akan melihat isi dari home.html

## Adventurer Power Level

Setelah memperlihatkan bagaimana spring bekerja, guild master juga memperlihatkan sebuah aplikasi yang dahulu digunakan
untuk menghitung kekuatan seorang adventurer di guild. Guild master berharap dengan memperlihatkan aplikasi tua tersebut, ingatan anda
akan semakin kembali.

```java
@Controller
public class AdventurerController {

    @Autowired
    private AdventurerCalculatorService adventurerCalculatorService;

    @RequestMapping("/adventurer/countPower")
    private String showAdventurerPowerFromBirthYear(@RequestParam("birthYear")int birthYear, Model model) {
        model.addAttribute("power", adventurerCalculatorService.countPowerPotensialFromBirthYear(birthYear));
        return "calculator";
    }
}
```

Ada beberapa kata di sana yang membangkitkan ingatan anda. Kata service dan Autowired.

Anda melihat bahwa isi dari folder service terdiri dari interface `AdventurerCalculatorService` dan class yang melakukan implements interface
tersebut `AdventurerCalculatorServiceImpl`

Anda melihat `AdventurerCalculatorService` hanya interface biasa. Namun, pada `AdventurerCalculatorServiceImpl` anda melihat anotasi lagi.

```java
@Service
public class AdventurerCalculatorServiceImpl implements AdventurerCalculatorService
```

Class yang melakukan implementasi interface memiliki anotasi `@Service` Melihat hal itu anda ingat pada tujuan `@Autowired`

`@Autowired` akan mencari secara otomatis kelas yang melakukan implementasi interface yang di-declare. Dengan demikian inisiasi tidak dilakukan
secara manual, tapi menggunakan anotasi ini. Anda menyadari bahwa implementasi ini terdengar familiar bagi anda.
Namun, saat ini tidak bisa mengingatnya. Guild master mengatakan bahwa ia juga tidak tahu kenapa harus menggunakan anotasi tersebut.
Aplikasi tersebut dibuat oleh seorang pahlawan dahulu kala yang mengajarkan sihir spring kepada mereka.

Mata anda tertuju pada parameter di controller.Pada aplikasi contoh tadi, anda juga melihat parameter bernama model. Guild master lalu menjelaskan fungsi parameter tersebut.
Model digunakan untuk passing data ke view, ke file html. Hal itu berarti akan ada variable bernama "power" dengan nilai hasil perhitungan
fungsi `countPowerPotensialFromBirthYear`.

```java
@Override
    public int countPowerPotensialFromBirthYear(int birthYear) {
        int rawAge = getRawAge(birthYear);
        if (rawAge<30) {
            return rawAge*2000;
        } else if (rawAge <50) {
            return rawAge*2250;
        } else {
            return rawAge*5000;
        }
    }

    private int getRawAge(int birthYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear-birthYear;
    }
```

Fungsi tadi akan menerima input dan menghitung kekuatan adventurer. Hasil perhitungan tadi akan di kirim ke html.

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>Adventurer Calculator</title>
  </head>
  <body>
    <h2>Welcome</h2>
    <h3 th:text="${'the power is ' + power}">to the guild</h3>
  </body>
</html>
```

Untuk dapat menampilkan data yang sudah dikirim melalui controller di spring, anda akan membutuhkan sihir lain.
Sihir itu dikenal dengan nama template engine. Guild menggunakan thymeleaf sebagai template engine.
Pemakaian dasarnya seperti yang anda dapat lihat.

Ada deklarasi `xmlns:th="http://www.thymeleaf.org"` untuk mulai menggunakan thymeleaf.

Lalu ada `th:text`. Fungsinya adalah untuk menggantikan teks yang ada pada tag itu dengan apa yang ada pada `th:text`

Untuk memanggil variable yang diberikan controller, secara umum dilakukan dengan cara
`th:[th operation ex:text]="${nama-variable}"`

Untuk dapat memasukkan string lain dapat dilakukan dengan
`th:[th operation]="${'other string' + nama-variable}"`

Anda lalu merasa ingin tahu bagaimana bentuk html pada aplikasi dasar sebelumnya.

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
  </head>
  <body>
    <h1>Welcome</h1>
    <h2 th:if="${name !=null}" th:text="${'Hello ' + name}"></h2>
  </body>
</html>
```

Anda melihat `th:if`. Guild master menjelaskan bahwa itu adalah penggunaan conditional.
Apabila kondisi dalam `th:if` terpenuhi, barulah tag tersebut dibuat. Dengan pengetahuan tersebut anda ingin iseng
terhadap sistem lama yang sudah tidak dipakai. Guild master mengizinkan anda untuk mengutak-atik sistem lama tersebut.

Anda merasa angka tersebut kurang bermanfaat sehingga butuh sedikit perubahan agar lebih bermakna.

1. Apabila kekuatannya antara 0 - 20000, tambahkan teks 'C class' disamping power di html
2. Apabila kekuatannya antara 20000 - 100000 tambahkan teks 'B class' .
3. Apabila kekuatannya lebih dari 100000, tambahkan teks 'A class'

Agar rapi anda merasa, yang melakukan klasifikasi adalah spring. Thymeleaf akan digunakan untuk menampilkan data saja.
Gunakanlah repository yang telah disediakan oleh guild master untuk melakukan perubahan tersebut. 
Untuk mendapatkan akses ke repository yang dimaksud, guild master
mengajari sebuah seni sihir yang dapat memanipulasi ruang dan waktu.

## The Art of Git

Guild master memperlihatkan kepada anda kemampuan dari sihir ruang-waktu bernama git.
Git adalah kekuatan yang dapat menyimpan mantra-mantra terdahulu. Anda bisa mengembalikan waktu untuk melihat
mantra-mantra terdahulu yang sudah tersimpan tersebut. Anda akan mempelajari Git dari dasar, jadi bersiaplah!

1. Hal yang pertama harus Anda lakukan adalah mendapatkan kekuatan tersebut. Jika Anda belum pernah memakai Git, maka
   anda dapat mendapatkannya [di sini](https://git-scm.com/download/).
2. Kemudian buatlah sebuah folder baru di mana saja dengan nama `the-art-of-git`.
3. Jika Anda menggunakan medium Windows, jalankanlah `Git Bash`. Jika Anda menggunakan Linux ataupun Mac, Anda dapat
   menggunakan `shell` kesukaan Anda (contoh: `bash`, `zsh`).
4. Bukalah folder `the-art-of-git` dengan menggunakan alat yang disebutkan sebelumnya. Sekarang Anda akan mempelajari
   kekuatan Git menggunakan perintah berbasis teks.
5. Setelah masuk ke dalam folder `the-art-of-git`, eksekusikan perintah `git init`. Hasil eksekusi ini akan membuat
   folder tersebut menjadi sebuah Git repository (disingkat repo), tempat Anda akan menyimpan berbagai macam mantra.
6. Eksekusikan perintah `git status` dan Anda akan melihat status dari repo Anda tersebut.

Selamat! Anda telah berhasil mempelajari perintah awal dalam menggunakan Git. Hal yang harus dilakukan selanjutnya
adalah memberitahukan identitas Anda kepada Git.

1. Aturlah _username_ dan _email_ Anda sebagai penanda identitas Anda, kedua hal ini akan digunakan untuk
   mengidentifikasi diri Anda saat melakukan _commit_. Jika sudah pernah melakukan hal ini, maka langkah konfigurasi di
   bawah ini dapat dilewati.
2. Eksekusikan perintah `git config user.name <Nama Anda>` dan `git config user.email <Email Anda>`. Sebagai contoh:
   `git config user.name "Yotsuba Nakano"` dan `git config user.email "yotsuba.nakano@gmail.com"`.
3. Jika Anda ingin mengatur identitas Anda secara global agar tidak perlu mengatur _username_ dan _email_ setiap kali
   membuat repo baru, tambahkan _flag_ `--global` ketika mengeksekusi `git config`. Contoh:
   `git config --global user.name "Yotsuba Nakano"` dan `git config --global user.email yotsuba.nakano@gmail.com`.

Kemudian Anda akan mempelajari kekuatan sesungguhnya dari Git, yaitu menyimpan mantra-mantra.

1. Buatlah sebuah _file_ bernama **README.md** di dalam folder `the-art-of-git` dan tulislah sesuai dengan format
   berikut.

   ```text
   Nama : <Nama Anda>

   NPM : <NPM Anda>

   Kelas : <A/B/C>
   ```

2. Eksekusi perintah `git status` dan Anda akan melihat sebuah _untracked file_.
3. Selanjutnya eksekusikan perintah `git add README.md`.
4. Eksekusikan kembali perintah `git status` dan Anda akan melihat bahwa file _README.md_ sekarang berstatus
   `Changes to be committed`. Itu berarti _README.md_ akan ditambahkan pada _commit_ selanjutnya.
5. Untuk menyimpan perubahan tersebut, eksekusikan perintah `git commit -m <Commit Message>`. Buatlah _commit message_
   yang merepresentaikan perubahan apa yang Anda lakukan, misalkan `git commit -m "Menambahkan README"`.

   Tambahan:

   Pertolongan Pertama Pada Vim (P3V): jika anda tidak sengaja mengeksekusi `git commit` tanpa _flag_ `-m` dan kemudian
   terjebak di vim, selamat Anda telah masuk ke dalam jurang!

   - Jika Anda ingin langsung keluar, tekan tombol `esc` untuk kembali ke _command mode_ dan tuliskan `:q` lalu `enter`.
     (Jika tidak berhasil coba gunakan `:q!`). Lalu lakukan `git commit` dengan flag `-m`.
   - Jika Anda ingin membuat _commit message_ terlebih dahulu sebelum keluar, tekan `i` untuk masuk ke _insert mode_.
     Ketikkan _commit message_ yang Anda inginkan, lalu tekan `esc` untuk kembali ke _command mode_. Setelah itu tulis
     `:wq` lalu `enter`. Maka _commit_ Anda sudah berhasil tersimpan.

6. Setelah Anda berhasil membuat _commit_, anda dapat menggunakan perintah `git log` untuk melihat semua _commit_ yang
   pernah Anda simpan sebelumnya.

Selamat! Anda telah mempelajari salah satu kekuatan dari Git, yaitu menyimpan mantra. Anda dapat membagikan repo yang
berisi mantra tersebut dengan melakukan hal berikut.

1. Buka [gitlab.com](https://gitlab.com) lalu login atau register akun Anda.
2. Buat sebuah repo baru bernama **The Art of Git** dan pastikan _visibility_-nya **Public**.
3. Cari tombol _clone_ dan anda akan melihat akan ada dua jenis URL, SSH dan HTTPS. Salin yang HTTPS URL.
4. Kemudian di dalam folder `the-art-of-git` eksekusikan perintah `git remote add origin <URL>` untuk menambahkan Gitlab
   repo Anda sebagai _remote repository_. Contoh:
   `git remote add origin https://gitlab.com/yotsubanakano/the-art-of-git.git`. Sebagai catatan, `origin` merupakan
   alias dari url repo Anda. Anda dapat mengecek semua _remote_ repo yang ada dengan perintah `git remote -v`.
5. Untuk menyimpan _commit_ Anda ke Gitlab repo Anda, eksekusikan perintah `git push origin master`. Perintah
   `git push` akan 'mendorong' semua _commit_ di _local_ yang belum ada di _remote_ repo. `origin` menandakan bahkan
   Anda mendorong ke url repo dengan alias `origin`. `master` menandakan bahwa Anda mendorong ke _branch_ `master` di
   repo `origin`.

Silahkan cek Gitlab repo Anda untuk melihat perubahan yang sudah Anda buat.

## Alternate Universe

Selanjutnya Anda akan menggunakan repo ini untuk mempelajari kekuatan Git lebih lanjut.
1. _Clone_ repo ini dengan mengeksekusi perintah `git clone <URL repo>`.
2. Cek _remote url_ dengan perintah `git remote -v`. Anda akan melihat url _remote_ `origin` merupakan Gitlab repo ini.
3. Ubah nama `origin` menjadi `upstream` dengan perintah `git remote rename origin upstream`.
4. Buatlah sebuah Gitlab repo baru dengan nama bebas dan pastikan _visibility_-nya **Public**. Misalkan nama repo-nya
   adalah `AP 2020`.
5. Selanjutnya salin URL HTTPS repo tersebut seperti hal yang Anda lakukan sebelumnya dan tambahkan _remote_ origin dengan
   perintah `git remote add origin <URL REPO>`. Contoh:
   `git remote add origin https://gitlab.com/yotsubanakano/ap-2020.git`.
6. Cek kembali _remote_ URL Anda dengan perintah `git remote -v`. Anda akan melihat akan ada dua _remote_ url yaitu `origin`
   dan `upstream`.
7. Eksekusi perintah `git push origin master` untuk mendorong repo tersebut ke Gitlab repo Anda.

Kemudian Anda akan belajar salah satu kekuatan Git yaitu _branching_. _Branching_ adalah kekuatan yang dapat
membuat sebuah _alternate universe_ di repo Anda. Semua perubahan yang dilakukan di _branch_ lain tidak akan
mempengaruhi _branch_ utama.

1. Jalankan **IntelliJ IDEA** dan buka folder repo ini.
2. Buka file [`Tutorial0Application.java`](src/main/java/id/ac/ui/cs/tutorial0/Tutorial0Application.java) lalu Anda akan
   melihat tombol `run` berupa panah hijau di samping kiri class `Tutorial0Application`. Jalankan aplikasi Spring dan
   kemudian Anda bisa mengaksesnya di alamat `http://localhost:8080`.
3. Selanjutnya buat _branch_ baru dengan mengeksekusi perintah `git checkout -b tutorial-0`. `git checkout` merupakan
   perintah untuk pindah ke _branch_ lain. Flag `-b` artinya Anda membuat _branch_ baru. `tutorial-0` merupakan nama
   _branch_ baru yang Anda buat. Anda dapat mengecek semua _branch_ yang ada di repo Anda dengan perintah `git branch -v`.
4. Buka file [`MainController.java`](src/main/java/id/ac/ui/cs/tutorial0/controller/MainController.java) kemudian ubah
   _return value_ di method **home** seperti berikut.

   ```diff
   ...

   private String home() {
   -   return "home";
   +   return "house";
   }

   ...
   ```

   Baris merah artinya mantra tersebut dihapus dan diubah/ditambahkan menjadi mantra yang berada di baris hijau. Buatlah
   _commit_ untuk perubahan tersebut.
5. Untuk mendorong perubahan di _branch_ `tutorial-0`, gunakan perintah `git push origin tutorial-0`.

Anda sudah berhasil membuat perubahan di _branch_ `tutorial-0`. Sekarang Anda akan kembali melakukan perubahan di _branch_
`master`.
1. Anda dapat kembali ke _branch_ `master` dengan mengeksekusi perintah `git checkout master`.
2. Masih di _file_ [`MainController.java`](src/main/java/id/ac/ui/cs/tutorial0/controller/MainController.java), ubahlah
   _return value_ di method **home** seperti berikut.

   ```diff
   ...

   private String home() {
   -   return "home";
   +   return "rumah";
   }

   ...
   ```
   
   Buatlah _commit_ yang berbeda untuk perubahan tersebut.
3. Anda kemudian dapat menggabungkan perubahan di _branch_ `tutorial-0` tadi ke _branch_ `master` dengan mengeksekusi
   perintah `git merge tutorial-0` yang mana `tutorial-0` merupakan nama _branch_ yang ingin Anda gabungkan.

Pasti sekarang Anda akan melihat ada masalah berupa _merge conflict_. Tenang saja, hal ini memang seharusnya terjadi dan
akan sering terjadi ketika Anda menggunakan Git. Sekarang saatnya Anda menjadi pasukan perdamaian menghentikan konflik yang
terjadi karena perbedaan antar mantra yang berada di _branch_ atau _timeline_ berbeda.

Buka kembali _file_ [`MainController.java`](src/main/java/id/ac/ui/cs/tutorial0/controller/MainController.java) yang terdapat
konflik di dalamnya. Anda akan mendapatkan _file_ yang isinya seperti berikut.

   ```diff
   ...

   private String home() {
<<<<<<< HEAD
       return "rumah";
=======
       return "house";
>>>>>>> tutorial-0
   }

   ...
   ```

Perhatikan akan ada dua bagian dengan label nama _branch_ `HEAD` dan `tutorial-0`. Bagian yang berada di antara `HEAD` dan
`===` merupakan perubahan yang terjadi di _branch_ `master` sedangkan bagian yang berada di antara `===` dan `tutorial-0`
merupakan perubahan yang terjadi di _branch_ `tutorial-0`. Untuk menyelesaikan konflik tersebut, ada tiga pilihan yang dapat
Anda lakukan.

1. Mengambil perubahan dari `master` dan menghapus perubahan dari `tutorial-0`.
   
   Hasilnya akan terlihat sebagai berikut.

   ```java
   ...

   private String home() {
       return "rumah";
   }

   ...
   ```
2. Mengambil perubahan dari `tutorial-0` dan menghapus perubahan dari `master`.
   
   Hasilnya akan terlihat sebagai berikut.

   ```java
   ...

   private String home() {
       return "house";
   }

   ...
   ```
3. Menggabungkan perubahan dari kedua _branch_ ataupun membuat perubahan baru yang berbeda. Contohnya sebagai berikut:

   ```java
   ...

   private String home() {
       return "rumah house";
   }

   ...
   ```

Setelah menyelesaikan konflik, lakukanlah _commit_ dan dorong hasilnya ke _branch_ `master` Gitlab repo Anda.

## Back To The Past

Coba hentikan dan jalankan kembali aplikasi spring Anda. Buka kembali `http://localhost:8080` dan pastinya akan terjadi
_error_. Bagaimana cara untuk mengembalikannya ketika masih berjalan dengan benar?

Tenang saja, Anda sudah menggunakan kekuatan Git yang salah satunya dapat mengembalikan waktu ketika mantra yang Anda buat
masih bekerja dengan baik.

1. Eksekusikan perintah `git log` untuk melihat semua perubahan yang terjadi di repo Anda. Misalkan sebagai berikut.

   ```text
    commit bf02fdc2ffd8876c1d911bdc9527ad68adb0dd6d (HEAD -> master, origin/master)
    Merge: 6876365 30e94af
    Author: Yotsuba Nakano <yotsuba.nakano@gmail.com>
    Date:   Sun Jan 26 22:51:07 2020 +0700

        fix conflict

    commit 68763658f43d8226cd46647ea681794fc4d7d393
    Author: Yotsuba Nakano <yotsuba.nakano@gmail.com>
    Date:   Sun Jan 26 22:31:07 2020 +0700

        Change home to rumah

    commit 30e94afb32ea21e4bff78c93879e85b3831e75e2 (tutorial-0)
    Author: Yotsuba Nakano <yotsuba.nakano@gmail.com>
    Date:   Sun Jan 26 22:15:06 2020 +0700

        Change home to house

    commit 7a52d6f3984b95c5c0e807580c260562eed37aae (upstream/master, upstream/HEAD)
    Author: adrika-novrialdi <adrika.novrialdi@gmail.com>
    Date:   Sat Jan 25 13:10:39 2020 +0700

        Add tutorial 0 readme

    commit 832c65b3ec50ec599b90291fd2b838204e752e33
    Author: adrika-novrialdi <adrika.novrialdi@gmail.com>
    Date:   Sat Jan 25 13:10:12 2020 +0700

        Create basic spring application for tutorial

    commit 48785ab2deab9b702ae227168bed90de4e71a547
    Author: adrika-novrialdi <adrika.novrialdi@gmail.com>
    Date:   Fri Jan 24 18:54:40 2020 +0700

        Create Tutorial 0 Application

    commit 01c4ac473491c21540b71a6d69540e3002a82ce2
    Author: adrika-novrialdi <adrika.novrialdi@gmail.com>
    Date:   Fri Jan 24 16:06:44 2020 +0700

        Init AdvProg Tutorial Repository

   ```
2. Perhatikan setiap _commit_ dan perkirakan mana _commit_ yang masih membuat aplikasi Anda berjalan normal. Kemudian
   gunakan perintah `git checkout <commit hash>` untuk berpindah ke _commit_ tersebut. Contoh:
   `git checkout 7a52d6f3984b95c5c0e807580c260562eed37aae`.

3. Sekarang Anda dapat mencoba menjalankan kembali aplikasi Anda. Jika sudah berjalan normal dan Anda merasa bahwa
   _commit_ tersebut merupakan _commit_ yang benar, salin _commit hash_ tersebut dan kembali ke `HEAD` dengan perintah
   `git checkout master`.
4. Selanjutnya Anda akan melakukan _revert_ ke _commit_ yang Anda pilih tadi dengan perintah `git revert <commit hash>`.
   Contohnya: `git revert 7a52d6f3984b95c5c0e807580c260562eed37aae`. _revert_ akan membuat _commit_ baru yang menandakan
   perubahan baru.
5. Dorong kembali _commit_ tersebut ke Gitlab repo Anda.

Mungkin Anda pernah mendengar kekuatan lain dari Git yang mirip seperti _revert_ yaitu _reset_. Keduanya sama-sama bisa
mengembalikan perubahan, tetapi _revert_ lebih aman digunakan apabila perubahan tersebut sudah masuk di _online_ repo.
_revert_ mengembalikan perubahan ke sebuah _commit_ dengan membuat _commit_ baru, sedangkan _reset_ mengembalikan perubahan
dengan cara menghapus beberapa _commit_ kebelakang.

## Checklist

- [ ] Membaca tutorial ini
- [ ] Membuat implementasi powerClassifier pada bagian service
- [ ] Membuat perubahan agar controller dan html (thymeleaf) dapat menampilkan data perubahan yang dimaksud
- [ ] Membuat repo `the-art-of-git` seperti pada contoh.
- [ ] Membuat _branch_ `tutorial-0` dan melakukan perubahan seperti pada contoh serta mendorongnya ke Gitlab Repo.
- [ ] Melakukan perubahan di _branch_ `master` dan melakukan _merge_ dari _branch_ `tutorial-0` serta melakukan
      _resolve conflict_ seperti pada contoh.
- [ ] Mendorong hasil _resolve conflict_ sebelumnya ke Gitlab repo dan melakukan _revert_ ke _commit_ yang tidak
      bermasalah seperti pada contoh. 
