# Eager vs Lazy Initialization


# Eager Initialization
Eager initialization adalah cara paling mudah dalam menerapkan singleton pattern. Caranya hanya membuat sebuah Field yang sudah diinisiasi dengan objek kelas itu sendiri. Sehingga ketika ingin mendapatkan instance dari kelas tersebut hanya dengan mereturn field tersebut.

###Pros

- Sangat simpel dalam mengimplementasinya

###Cons

- Penggunaan resource yang sia - sia karena bisa saja instance kelasnya tidak dipakai tapi sudah diinisiasi.

#Lazy Initialization
Lazy Initialization pada dasarnya mengecek terlebih dahulu apakah sudah ada instance yang dibuat, jika sudah maka akan mengembalikan instance tersebut, jika belum maka akan membuat instance baru.

###Pros

- Membuat objek hanya ketika diperlukan saja

###Cons

- Pada pemanggilan pertamanya akan memakan waktu jika proses pembuatan instance-nya membutuhkan waktu yang cukup lama.
- Isu pada multithreading.