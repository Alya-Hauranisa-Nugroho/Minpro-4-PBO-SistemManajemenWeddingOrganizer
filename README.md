# 💍 Sistem Manajemen Wedding Organizer

## Houry Do Wedds

#### Alya Hauranisa Nugroho | 2509116005 | Sistem Informasi A 2025

#### Mata Kuliah: Pemrograman Berorientasi Objek

---

## 📌 Deskripsi Program

Sistem Manajemen Wedding Organizer merupakan program berbasis bahasa pemrograman Java yang digunakan untuk mengelola data pada usaha Wedding Organizer "Houry Do Wedds" secara sederhana.

Program ini dibuat dengan menerapkan konsep Object Oriented Programming atau OOP, serta fitur fitur sederhana yang mendukung CRUD yang meliputi _Create, Read, Update, Delete_. Program ini memungkinkan pengguna untuk mengelola dan mencatat informasi seperti pada data pelanggan, paket wedding, pemesanan wedding, serta vendor.

---

## 📂 Struktur Package, Class, dan MVC

<img width="480" height="490" alt="image" src="https://github.com/user-attachments/assets/321e5288-ef7e-420f-81c8-9112e56cb4f2" />


Program Sistem Manajemen Wedding Organizer, setiap class disusun dalam beberapa package yang menerapkan struktur MVC, yaitu _Model_, _Controller_, dan _View_. Struktur ini diterapkan untuk merapikan kode program, memisahkan fungsi setiap bagian, serta memudahkan proses pengelolaan dan pengembangan program. Setiap package memiliki fungsi dan classnya masing masing, diantaranya:

---

### 📦 Package `com.mycompany.weddingorganizerminpro3` sebagai Main
Package ini merupakan package utama yang berisi class WeddingOrganizerMinpro2.java sebagai _entry point_program melalui method main().

#### 1. `WeddingOrganizerMinpro3.java`

Class ini merupakan class utama yang menjadi _entry point_ program. Class ini digunakan untuk menjalankan program dan menampilkan menu utama.

Menu utama pada program ini terdiri dari:

1. Menu Tambah
2. Menu Tampilkan
3. Menu Update
4. Menu Hapus
5. Menu Cetak Dokumen
6. Keluar >>>

---

### 📦 Package `model` sebagai Model
Package ini merupakan bagian Model dalam penerapan struktur  MVC. Model berfungsi untuk menyimpan dan mengelola data yang digunakan dalam Sistem Manajemen Wedding Organizer. Setiap class di dalam package ini mewakili objek yang ada dalam sistem dan memiliki atribut serta method untuk mengelola datanya. Class yang terdapat dalam package ini, diantaranya:

#### 1. `Pelanggan.java`

Class ini merupakan class data yang merepresentasikan pelanggan yang melakukan pemesanan pada Wedding Organizer.

Atribut yang digunakan meliputi:

* `idPelanggan`
* `nama`
* `noHp`

#### 2. `PaketWedding.java`

Class ini merupakan class data yang merepresentasikan paket wedding yang tersedia.

Atribut yang digunakan meliputi:

* `idPaket`
* `namaPaket`
* `harga`

#### 3. `PemesananWedding.java`

Class ini merupakan class data yang merepresentasikan data pemesanan wedding.

Atribut yang digunakan meliputi:

* `idBooking`
* `pelanggan`
* `paketWedding`
* `venue`
* `tanggalAcara`
* `pax`

#### 4. `Vendor.java`

Class ini merupakan superclass yang digunakan sebagai class induk untuk jenis-jenis vendor yang diolah pada Wedding Organizer.

Class ini menyimpan atribut umum yang dimiliki oleh setiap vendor, yaitu:

* `idVendor`
* `namaVendor`
* `noTelepon`

Atribut dan method umum yang terdapat dalam class ini kemudian akan digunakan oleh subclass yang mewarisi class `Vendor`.

#### 5. `VendorCatering.java`

Class ini merupakan subclass atau class anak yang mewarisi sifat dari dari class `Vendor`. Class ini mewarisi informasi umum vendor dari superclass dan memiliki atribut tambahan yang khusus digunakan untuk vendor catering, yaitu:

* `jenisMasakan`
* `sistemPenyajian`
* `hargaPerPax`

#### 6. `VendorDekorasi.java`

Class ini merupakan subclass atau class anak yang mewarisi sifat dari dari class `Vendor`. Class ini mewarisi informasi umum vendor dari superclass dan memiliki atribut tambahan yang khusus digunakan untuk vendor dekorasi, yaitu:

* `temaDekorasi`
* `jenisDekorasi`
* `hargaPaketDekorasi`

#### 7. `Cetakable.java`

Class ini merupakan interface yang digunakan untuk mendefinisikan fungsi pencetakan dokumen pada sistem manajemen Wedding Organizer. Interface ini menyediakan method cetakDokumen() yang dapat diterapkan oleh class yang membutuhkan proses pencetakan dokumen, khususnya pada data pemesanan wedding dan vendor.

---

### 📦 Package `controller` sebagai Controller

Package ini merupakan bagian Controller dalam penerapan struktur MVC. Controller berfungsi untuk mengatur alur program dan menghubungkan antara Model dengan View. Package ini berisi class yang menangani operasi CRUD serta validasi input dari pengguna sebelum data diproses. Class yang terdapat dalam package ini diantaranya:

#### 1. `WeddingCRUD.java`

Class ini merupakan class yang menangani seluruh proses utama CRUD pada program.

Data yang dikelola pada class ini meliputi:

* Pelanggan
* Paket Wedding
* Pemesanan Wedding
* Vendor

Pada class ini, ditambahkan juga ArrayList dan data _dummy_ untuk setiap data yang dikelola pada Sistem Manajemen Wedding Organizer.

#### 2. `InputValidator.java`

Class InputValidator digunakan untuk membantu memvalidasi input yang dimasukkan oleh pengguna agar sesuai dengan format yang dibutuhkan program. Class ini memiliki beberapa method, yaitu:

* bacaInt(), yaitu method yang berfungsi membaca dan memvalidasi input berupa angka.
* bacaPilihan(), yaitu method yang berfungsi untuk membaca pilihan menu dari pengguna.
* bacaTeks(), yaitu method membaca dan memvalidasi input berupa teks.

---

### 📦 Package `view` sebagai View

Package ini merupakan bagian View dalam penerapan struktur MVC. View berfungsi untuk menampilkan informasi kepada pengguna. Package ini mengatur tampilan menu dan pesan yang muncul saat program dijalankan. Class yang terdapat dalam package ini, di antaranya:

#### 1. `Menu.java`

Class ini digunakan untuk menampilkan menu yang terdapat pada program, baik menu utama maupun submenu yang ada didalamnya. Class ini memiliki beberapa method yang digunakan untuk tampilan program, yaitu:

* tampilkanMenuUtama()
* tampilkanMenuTambah()
* tampilkanMenuTampilkan()
* tampilkanMenuUpdate()
* tampilkanMenuHapus()
* tampilkanMenuCetakDokumen()
* tampilkanMenuJenisVendor()
* tampilkanMenuTampilkanVendor()

#### 2. `Pesan.java`

Class ini digunakan untuk menampilkan pesan kepada pengguna, seperti pesan berhasil, pesan kesalahan, atau informasi lainnya selama program berjalan. Pada class ini terdapat method tampilkanPesan() yang digunakan untuk menampilkan pesan dengan format "> [ pesan ] <".


---

## ⭐ Penerapan Encapsulation

<img width="476" height="129" alt="image" src="https://github.com/user-attachments/assets/20a36d1b-129c-4073-b2fb-5937629edaf9" />

Pada program ini, saya menerapkan konsep encapsulation dengan menyembunyikan atribut menggunakan access modifier private, lalu menyediakan method getter dan setter sebagai jalur akses untuk membaca atau mengubah data. Konsep encapsulation saya terapkan pada seluruh class data pada model. Hal ini bertujuan agar data dalam object tidak dapat diakses atau diubah secara langsung dari luar class.

Sebagai contoh, pada class PaketWedding terdapat beberapa method berikut:

<img width="443" height="306" alt="image" src="https://github.com/user-attachments/assets/0ec01a73-2fc4-4af3-9a07-988e424a7045" />

Pada gambar di atas digunakan method getter, yaitu getIdPaket(), getNamaPaket(), dan getHarga(), digunakan untuk mengambil nilai atribut idPaket, namaPaket, dan harga.

<img width="987" height="202" alt="image" src="https://github.com/user-attachments/assets/5fb83b6b-fe46-4c61-893e-11f28170b762" />

Selain menerapkan getter, saya juga menerapkan method setter yaitu setHarga() yang digunakan untuk mengubah nilai atribut harga. Pada method setHarga(), saya juga menambahkan validasi data jika nilai harga yang dimasukkan kurang dari atau sama dengan 0, maka akan menampilkan pesan seperti pada gambar di atas.

---

## ⭐ Penerapan Inheritance

Pada program ini, saya menerapkan konsep inheritence dengan menjadikan class Vendor sebagai superclass atau class induk dari subclass VendorCatering dan VendorDekorasi.

Atribut yang bersifat umum seperti ID vendor, nama vendor, dan nomor telepon ditempatkan pada superclass Vendor. Kedua subclass kemudian mewarisi atribut dan method tersebut serta menambahkan atribut khusus sesuai dengan jenis vendornya. Penerapan inheritance bertujuan agar atribut dan method yang sama tidak perlu ditulis kembali pada masing-masing subclass, sehingga dapat digunakan untuk efisiensi. Penerapan inheritence pada class VendorCatering dan VendorDekorasi digunakan untuk mengelola data vendor berdasarkan jenisnya.

Implementasi inheritance pada kode dapat dilihat pada gambar berikut:

<img width="1724" height="314" alt="image" src="https://github.com/user-attachments/assets/85a24a50-5dfd-4c35-adc2-778cbe1aa6f6" />

<img width="1188" height="344" alt="image" src="https://github.com/user-attachments/assets/ceabd1a2-747c-4f69-8e75-87b569fb2702" />


Pada gambar di atas, diketahui bahwa konsep inheritance diterapkan pada VendorCatering dan VendorDekorasi yang merupakan subclass dari Vendor menggunakan keyword extends. Class Vendor sebagai superclass menyimpan atribut umum, sedangkan kedua subclass menambahkan atribut khusus sesuai dengan jenis vendor. Keyword super() juga digunakan untuk untuk menginisialisasi atribut yang diwarisi dari Vendor. Pada jenis vendor catering, terdapat atribut tambahan seperti jenisMasakan, sistemPenyajian, dan hargaPerPax. Sementara pada jenis vendor dekorasi, terdpat atribut tambahan seperti temaDekorasi, jenisDekorasi, dan hargaPaketDekorasi. Pada constructor digunakan super() untuk menginisialisasi atribut yang diwarisi dari Vendor.

---

## ⭐ Penerapan Polymorphism

### 1. Overriding

Pada program ini saya menerapkan polymorphism melalui overriding, yaitu subclass memberikan implementasi yang berbeda pada method yang sudah didefinisikan oleh superclass Vendor. Class Vendor merupakan abstract class yang memiliki beberapa abstract method yang wajib diimplementasikan oleh subclass. Overriding digunakan karena setiap jenis vendor memiliki kebutuhan dan perilaku yang berbeda, meskipun menggunakan method yang sama.

Implementasi polymorphism pada kode dapat dilihat pada gambar berikut:

<img width="857" height="643" alt="image" src="https://github.com/user-attachments/assets/b914ab33-15d9-459b-8d9d-ea94396ec014" />

<img width="970" height="623" alt="image" src="https://github.com/user-attachments/assets/9bdbcf59-5a0e-4969-9340-2811c8a004a3" />

Pada method getJenisVendor(), overriding diperlukan karena setiap subclass memiliki jenis vendor yang berbeda. VendorCatering mengembalikan Catering, sedangkan VendorDekorasi mengembalikan Dekorasi.

Pada method getHarga() dan setHarga(), overriding digunakan karena setiap jenis vendor memiliki atribut harga yang berbeda. VendorCatering menggunakan hargaPerPax, sedangkan VendorDekorasi menggunakan hargaPaketDekorasi. Dengan begitu, method yang sama dapat mengambil dan mengubah harga sesuai dengan jenis vendor.

Pada method tampilkanInfo(), overriding digunakan karena informasi yang perlu ditampilkan pada setiap jenis vendor berbeda. VendorCatering menampilkan informasi seperti jenis masakan dan sistem penyajian, sedangkan VendorDekorasi menampilkan tema dan jenis dekorasi. Method super.tampilkanInfo() tetap digunakan untuk menampilkan informasi umum yang berasal dari superclass Vendor.

### 2. Overloading

Pada program ini saya juga menerapkan polymorphism melalui overloading, yaitu membuat beberapa method dengan nama yang sama tetapi memiliki parameter yang berbeda. Pada class VendorCatering, method cetakDokumen() berasal dari interface Cetakable dan diimplementasikan dengan bentuk cetakDokumen() tanpa parameter. Method tersebut kemudian melakukan pemanggilan terhadap method cetakDokumen(int jumlahPax) yang memiliki parameter tambahan berupa jumlah pax.

Overloading diterapkan karena proses pencetakan dokumen pembayaran pada vendor catering membutuhkan jumlah pax untuk menghitung total pembayaran. Berbeda dengan vendor dekorasi yang harga paketnya sudah tetap sehingga dapat langsung dicetak tanpa memerlukan parameter tambahan.

<img width="962" height="551" alt="image" src="https://github.com/user-attachments/assets/7bad7842-6831-4f1c-a5c9-d5d03e485a03" />

Pada method cetakDokumen() tanpa parameter, digunakan sebagai implementasi method dari interface Cetakable. Method tersebut memanggil cetakDokumen(1) sebagai nilai awal jumlah pax. Sementara itu, method cetakDokumen(int jumlahPax) digunakan ketika jumlah pax perlu ditentukan secara langsung. Nilai jumlahPax kemudian dikalikan dengan hargaPerPax untuk mendapatkan total pembayaran vendor catering.

---

## ⭐ Penerapan Abstraction

Pada program ini saya menerapkan konsep abstraction melalui penggunaan abstract class dan abstract method. Abstraction digunakan untuk menyembunyikan detail implementasi tertentu dan hanya menampilkan bagian yang diperlukan oleh class turunannya. Dalam program ini, abstraction diterapkan pada class Vendor yang dijadikan sebagai abstract class karena Vendor berperan sebagai class dasar untuk berbagai jenis vendor pada program ini.

<img width="605" height="199" alt="image" src="https://github.com/user-attachments/assets/fd217837-2d90-43ac-b356-8ea13d22a737" />

Class Vendor dideklarasikan menggunakan keyword abstract, sehingga class tersebut tidak dapat dibuat menjadi objek secara langsung. Class ini digunakan sebagai superclass yang menjadi dasar bagi class VendorCatering dan VendorDekorasi. 

Penggunaan abstract class pada Vendor bertujuan untuk menyediakan struktur dasar yang dapat digunakan oleh berbagai jenis vendor, sedangkan detail yang berbeda pada masing-masing vendor akan diberikan oleh subclass.

Selain sebagai abstract class, Vendor juga memiliki beberapa abstract method, yaitu:

<img width="709" height="146" alt="image" src="https://github.com/user-attachments/assets/3a35050e-b0ea-4d9b-ba22-09d365d9257a" />

Abstract method merupakan method yang hanya dideklarasikan tanpa memiliki isi atau implementasi pada abstract class. Implementasi dari method tersebut kemudian wajib diberikan oleh subclass seperti VendorCatering dan VendorDekorasi sesuai dengan kebutuhan masing-masing.

Penerapan abstract method ini sebelumnya juga sudah dijelaskan pada bagian polymorphism melalui overriding. Method getJenisVendor(), getHarga(), dan setHarga() yang didefinisikan pada abstract class Vendor kemudian diberi override pada subclass dengan implementasi yang berbeda. 

---

## ⭐ Penerapan Interface, sebagai Nilai Tambah

Pada program ini saya menerapkan interface sebagai nilai tambah dengan menggunakan Cetakable. Interface digunakan untuk mendefinisikan fungsi tertentu yang dapat diterapkan oleh beberapa class. Pada program ini, Cetakable digunakan sebagai interface untuk mendefinisikan fungsi pencetakan dokumen.

Penerapan Interface pada program ini adalah sebagai berikut:

<img width="538" height="139" alt="image" src="https://github.com/user-attachments/assets/f4f0a17a-4ab2-4f54-a895-e6587ab79f59" />

Pada gambar di atas, method cetakDokumen() tidak memiliki implementasi di dalam interface. Sehingga, class yang menggunakan interface Cetakable wajib memberikan implementasi terhadap method tersebut menggunakan @Override.

<img width="798" height="206" alt="image" src="https://github.com/user-attachments/assets/57feb045-7417-43dd-8526-ed3979ec017c" />

Interface Cetakable kemudian diimplementasikan pada class PemesananWedding menggunakan keyword implements.

<img width="1025" height="382" alt="image" src="https://github.com/user-attachments/assets/b346ef31-6d00-413d-a843-0159470426ae" />

Karena PemesananWedding mengimplementasikan Cetakable, maka class tersebut wajib meng-override method cetakDokumen(). Pada implementasinya, method tersebut digunakan untuk mencetak invoice pemesanan wedding yang berisi informasi seperti ID booking, nama pelanggan, paket wedding, tanggal acara, venue, dan total harga pemesanan.

Selain diterapkan pada PemesananWedding, interface Cetakable juga diterapkan pada VendorCatering dan VendorDekorasi. Pada kedua class tersebut, method cetakDokumen() digunakan untuk mencetak bukti pembayaran vendor. 

---

## 📸 Dokumentasi dan Alur Program

Secara umum, alur program dimulai ketika pengguna menjalankan program selanjutnya dan akan diarahkan ke menu utama yang terdiri dari menu Tambah, Tampilkan, Update, Hapus, dan Keluar. Pengguna dapat memilih menu sesuai kebutuhan, kemudian memilih data yang ingin dikelola, yaitu data pelanggan, paket wedding, pemesanan wedding, maupun vendor. 

Apabila pengguna telah menyelesaikan proses CRUD yang dipilih dan memilih menu “Kembali ke Menu Utama”, program akan kembali ke menu utama sehingga pengguna dapat melakukan proses lainnya. Program akan terus berjalan selama pengguna belum memilih menu Keluar.

---

### Menu Utama

<img width="504" height="368" alt="image" src="https://github.com/user-attachments/assets/8a40468f-d679-45fb-954c-4af7dad9442d" />

Pada gambar di atas, ditampilkan menu utama dari program Sistem Manajemen Wedding Organizer. Terdapat 6 menu utama yang dapat dipilih, yaitu menu untuk menambahkan data, menampilkan data, menghapus data, mengupdate data, mencetak dokumen, serta menu untuk keluar dari program. Pengguna akan diminta untuk memilih salah satu dari kelima menu tersebut.

---

### 1. Menu Tambah

<img width="476" height="248" alt="image" src="https://github.com/user-attachments/assets/9cc63606-3804-4402-bb8e-315ea4b4f1a3" />

Ketika pengguna memilih “1” pada menu utama, pengguna akan masuk ke dalam Menu Tambah, di mana menu ini memungkinkan pengguna untuk memasukkan data baru pada data pelanggan, paket wedding, maupun pemesanan wedding. Pengguna dapat memilih salah satu jenis data yang ingin ditambahkan sesuai dengan kebutuhan. Pada tampilan tersebut, saya memilih menu “1", "yaitu Tambah Pelanggan”, sehingga program akan melanjutkan ke proses untuk memasukkan data pelanggan.

---

* **Tambah Pelanggan**

<img width="652" height="490" alt="image" src="https://github.com/user-attachments/assets/13fe427f-c92f-4c1d-9636-2b30e41cdf68" />

Selanjutnya, program akan menampilkan tempat untuk memasukkan data pelanggan. Pengguna diminta memasukkan ID Pelanggan, Nama Pelanggan, dan No HP. Setelah seluruh data berhasil dimasukkan, program menampilkan pesan bahwa data pelanggan berhasil ditambahkan, kemudian kembali menampilkan Menu Tambah agar pengguna dapat melanjutkan proses penambahan data lainnya.

Berikut merupakan proses penambahan data lainnya:

* **Tambah Paket Wedding**

<img width="648" height="232" alt="image" src="https://github.com/user-attachments/assets/82385aae-f5c2-4f6f-b81d-499c1bf0b9b4" />

* **Tambah Pemesanan Wedding**

<img width="472" height="574" alt="image" src="https://github.com/user-attachments/assets/03bda7f1-3ce7-4006-b3f8-0ce4747e2179" />

<img width="797" height="871" alt="image" src="https://github.com/user-attachments/assets/0989a8b0-11ab-4780-8a1e-71882967112e" />

* **Tambah Vendor**

<img width="471" height="220" alt="image" src="https://github.com/user-attachments/assets/9e231808-40c2-46a5-9fb7-c2a6f44c5fe6" />

Pada menu Tambah Vendor, pengguna terlebih dahulu memilih jenis vendor yang ingin ditambahkan.

<img width="674" height="227" alt="image" src="https://github.com/user-attachments/assets/94ded310-d2b0-4295-a632-f67653933790" />

Jika memilih vendor catering, pengguna memasukkan data umum vendor serta data khusus catering seperti jenis masakan, sistem penyajian, dan harga per pax.

<img width="668" height="221" alt="image" src="https://github.com/user-attachments/assets/1db7c2b2-4e77-41c1-a017-c2aa20f9d827" />

Jika memilih vendor dekorasi, pengguna memasukkan data umum vendor serta data khusus dekorasi seperti tema dekorasi, jenis dekorasi, dan harga paket dekorasi.

* **Kembali ke Menu Utama**

<img width="463" height="647" alt="image" src="https://github.com/user-attachments/assets/9eb1728f-6d74-4d0d-af8c-263207239392" />


Apabila telah menyelesaikan proses _create_, pengguna dapat memilih menu "5" untuk keluar dari Menu Tambah dan kembali ke Menu Utama.

---

### 2. Menu Tampilkan

<img width="468" height="248" alt="image" src="https://github.com/user-attachments/assets/9e9402ab-23ce-4d10-abc9-e8e0e652b806" />


Ketika pengguna memilih “2” pada menu utama, pengguna akan masuk ke dalam Menu Tampilkan, di mana menu ini memungkinkan pengguna untuk melihat data yang sudah ada pada data pelanggan, paket wedding, maupun pemesanan wedding. 

---

Berikut merupakan tampilan untuk Menu Tampilkan di setiap data:

* **Tampilkan Pelanggan**

<img width="470" height="338" alt="image" src="https://github.com/user-attachments/assets/6801f89b-bbc0-46aa-b1d8-58b1c8379c7c" />


* **Tampilkan Paket Wedding**

<img width="492" height="670" alt="image" src="https://github.com/user-attachments/assets/567103d8-74d2-4e78-9546-d17188a7679f" />


* **Tampilkan Pemesanan Wedding**

<img width="473" height="306" alt="image" src="https://github.com/user-attachments/assets/6b40f314-e123-4a53-bc8c-96804ce09528" />


* **Tampilkan Vendor**

<img width="473" height="224" alt="image" src="https://github.com/user-attachments/assets/53f50f51-081b-4b12-9963-76cd62d7b0b5" />

Pada menu Tampilkan Vendor, pengguna diminta untuk memilih vendor apa yang ingin dilihat. Pada gambar di atas, diketahui bahwa pengguna dapat melihat semua vendor, vendor catering saja, dan vendor dekorasi saja. Output dari masing masing menu tampilkan adalah sebagai berikut:

1. Tampilkan Semua Vendor

<img width="474" height="907" alt="image" src="https://github.com/user-attachments/assets/655b5659-f397-4eef-a4b5-a854d6bbd7bc" />

3. Tampilkan Vendor Catering

<img width="461" height="469" alt="image" src="https://github.com/user-attachments/assets/a204b304-7029-4d04-9002-9e115b5e8762" />

4. Tampilkan Vendor Dekorasi

<img width="477" height="692" alt="image" src="https://github.com/user-attachments/assets/0e7334eb-97cc-497f-9f87-10db3eca7fec" />


* **Kembali ke Menu Utama**

<img width="465" height="652" alt="image" src="https://github.com/user-attachments/assets/eb4f2bd2-13f5-4b9a-bab9-db16a239ccf1" />


Apabila telah menyelesaikan proses _read_, pengguna dapat memilih menu "5" untuk keluar dari Menu Tampilkan dan kembali ke Menu Utama.

---

### 3. Menu Update

<img width="468" height="248" alt="image" src="https://github.com/user-attachments/assets/72832003-3173-4091-987e-15311ed57433" />

Ketika pengguna memilih “3” pada menu utama, pengguna akan masuk ke dalam Menu Update. Menu ini digunakan untuk mengubah data yang sudah tersimpan pada program. Pengguna dapat memilih data yang ingin diperbarui, yaitu data pelanggan, paket wedding, maupun pemesanan wedding.

Pada Menu Update, pengguna dapat memilih salah satu dari 4 jenis data yang tersedia untuk diperbarui. Setelah memilih jenis data, pengguna akan diminta memasukkan ID dari data yang ingin diubah. Program kemudian akan mencari data berdasarkan ID tersebut. Apabila data ditemukan, pengguna dapat memasukkan informasi baru sesuai dengan atribut yang dapat diperbarui.

---

Berikut merupakan proses update pada setiap data:

* **Update Pelanggan**

<img width="641" height="532" alt="image" src="https://github.com/user-attachments/assets/0323c0bf-ee21-450e-a90e-54a7e1d09d09" />

Pada proses Update Pelanggan, program akan terlebih dahulu menampilkan data pelanggan yang ada. Selanjutnya, pengguna diminta memasukkan ID pelanggan yang ingin diperbarui. Setelah ID ditemukan, pengguna dapat mengubah nama pelanggan dan No HP. Setelah data berhasil diperbarui, program akan menampilkan pesan bahwa data pelanggan berhasil diupdate.

* **Update Paket Wedding**

<img width="698" height="827" alt="image" src="https://github.com/user-attachments/assets/87a520c4-31db-406b-8606-c2f1554c5c6a" />

Pada proses Update Paket Wedding, program akan terlebih dahulu menampilkan data paket wedding yang ada. Selanjutnya, pengguna diminta memasukkan ID paket yang ingin diperbarui. Setelah paket ditemukan, pengguna dapat mengubah harga paket wedding. Setelah proses berhasil dilakukan, program akan menampilkan pesan bahwa data paket berhasil diupdate.

* **Update Pemesanan Wedding**

<img width="680" height="529" alt="image" src="https://github.com/user-attachments/assets/4544024a-9703-4dc9-9b25-b8eda5468368" />

Pada proses Update Pemesanan Wedding, program akan terlebih dahulu menampilkan data pemesanan wedding yang ada. Selanjutnya, pengguna diminta memasukkan ID booking yang ingin diperbarui. Setelah data ditemukan, pengguna dapat mengubah venue, tanggal acara, dan jumlah pax sesuai dengan kebutuhan. Setelah data berhasil diperbarui, program akan menampilkan pesan bahwa data pemesanan berhasil diupdate.

* **Update Vendor**

<img width="611" height="638" alt="image" src="https://github.com/user-attachments/assets/c2738c51-8d0d-4636-9b33-a045e3a6a7e0" />

<img width="614" height="637" alt="image" src="https://github.com/user-attachments/assets/c57390a5-4b6e-4017-9819-5ae751384791" />

Pada proses Update Vendor, program akan terlebih dahulu menampilkan data vendor yang ada. Selanjutnya, pengguna diminta untuk memasukkan ID vendor yang ingin diperbarui. Setelah data ditemukan, pengguna dapat mengubah harga per pax apabila data yang dipilih merupakan jenis vendor catering, serta dapat mengubah harga paket dekorasi apabila data yang dipilih merupakan vendor dekorasi. Setelah data harga berhasil diperbarui, program akan menampilkan pesan bahwa data pemesanan berhasil diupdate.

* **Kembali ke Menu Utama**

<img width="463" height="651" alt="image" src="https://github.com/user-attachments/assets/008eaefd-5b6a-4b77-ac57-597540765500" />


Apabila telah menyelesaikan proses _update_, pengguna dapat memilih menu "5" untuk keluar dari Menu Update dan kembali ke Menu Utama.

---

### 4. Menu Hapus

<img width="466" height="242" alt="image" src="https://github.com/user-attachments/assets/eba4978f-a66d-4793-b003-b182441b1b04" />

Ketika pengguna memilih “4” pada menu utama, pengguna akan masuk ke dalam Menu Hapus. Menu ini digunakan untuk menghapus data yang sudah tersimpan pada sistem. Pengguna dapat memilih data yang ingin dihapus, yaitu data pelanggan, paket wedding, pemesanan wedding, maupun vendor.

Pada Menu Hapus, pengguna dapat memilih salah satu jenis data yang tersedia. Setelah memilih jenis data, pengguna akan diminta memasukkan ID dari data yang ingin dihapus. Program kemudian akan mencari data berdasarkan ID tersebut. Apabila data ditemukan, data akan dihapus dari daftar penyimpanan.

---

Berikut merupakan proses penghapusan pada setiap data:

* **Hapus Pelanggan**

<img width="559" height="470" alt="image" src="https://github.com/user-attachments/assets/98e55024-a21d-42d0-a0ad-3bc3d88fb1f9" />

Pada proses Hapus Pelanggan, program menampilkan daftar pelanggan yang ada, kemudian pengguna diminta memasukkan ID pelanggan yang ingin dihapus. Program akan mencari ID tersebut pada daftar pelanggan. Apabila ID ditemukan, data pelanggan akan dihapus dan program akan menampilkan pesan bahwa data pelanggan berhasil dihapus.

* **Hapus Paket Wedding**

<img width="546" height="794" alt="image" src="https://github.com/user-attachments/assets/a02e5db3-fa26-412f-9eec-e1491b1e4436" />


Pada proses Hapus Paket Wedding, program menampilkan daftar paket wedding yang ada, kemudian pengguna diminta memasukkan ID paket yang ingin dihapus. Program akan mencari ID tersebut pada daftar paket wedding. Apabila ID ditemukan, data paket akan dihapus dari sistem dan program akan menampilkan pesan bahwa data paket berhasil dihapus.

* **Hapus Pemesanan Wedding**

<img width="593" height="446" alt="image" src="https://github.com/user-attachments/assets/39748621-3221-4918-a6a4-5d237cd3d7af" />

Pada proses Hapus Pemesanan Wedding, program menampilkan daftar pemesanan wedding yang ada, kemudian pengguna diminta memasukkan ID booking yang ingin dihapus. Program akan mencari ID booking tersebut pada daftar pemesanan. Apabila ditemukan, data pemesanan akan dihapus dan program akan menampilkan pesan bahwa data pemesanan berhasil dihapus.

* **Hapus Vendor**

<img width="497" height="613" alt="image" src="https://github.com/user-attachments/assets/e6b0b93c-8a01-4a60-b493-e3cc5eead17c" />

Pada proses Hapus Vendor, program menampilkan daftar vendor yang ada, kemudian pengguna diminta memasukkan ID Vendor yang ingin dihapus. Program akan mencari ID Vendor tersebut pada daftar vendor. Apabila ditemukan, data vendor akan dihapus dan program akan menampilkan pesan bahwa data vendor berhasil dihapus.


* **Kembali ke Menu Utama**

<img width="460" height="654" alt="image" src="https://github.com/user-attachments/assets/853762ce-66e2-42fb-85c0-f0c66d05e3da" />


Apabila telah menyelesaikan proses _delete_, pengguna dapat memilih menu "5" untuk keluar dari Menu Hapus dan kembali ke Menu Utama.

---

### 5. Menu Cetak Dokumen

<img width="461" height="193" alt="image" src="https://github.com/user-attachments/assets/89dbd6d4-0dab-41ad-a48e-2b661f9fb427" />

Ketika pengguna memilih “5” pada menu utama, pengguna akan masuk ke dalam Menu Cetak Dokumen. Menu ini digunakan untuk mencetak dokumen yang berkaitan dengan transaksi pada sistem Wedding Organizer. Terdapat dua jenis dokumen yang dapat dicetak, yaitu invoice pemesanan wedding dan bukti pembayaran vendor.

Pada Menu Cetak Dokumen, pengguna dapat memilih jenis dokumen yang ingin dicetak. Setelah memilih jenis dokumen, pengguna akan diminta memasukkan ID data yang ingin dicetak. Program kemudian akan mencari data berdasarkan ID tersebut dan menampilkan dokumen sesuai dengan data yang dipilih.

---

Berikut merupakan proses pencetakan pada setiap dokumen:

* **Cetak Invoice Pemesanan Wedding**

<img width="652" height="742" alt="image" src="https://github.com/user-attachments/assets/cb2c77e7-50f7-4645-9307-040b6f37b4ae" />

Pada proses Cetak Invoice Pemesanan Wedding, program terlebih dahulu menampilkan daftar pemesanan wedding yang tersedia. Daftar tersebut berisi informasi seperti ID Booking, nama pelanggan, paket wedding, venue, tanggal acara, dan jumlah pax. Pengguna kemudian diminta memasukkan ID Booking yang ingin dicetak.

Apabila ID Booking ditemukan, program akan mencetak invoice pemesanan wedding yang berisi informasi ID Booking, pelanggan, paket wedding, tanggal acara, venue, serta total harga pemesanan. Total harga diperoleh dari proses perhitungan yang terdapat pada data pemesanan. Setelah invoice berhasil ditampilkan, program memberikan pesan bahwa invoice pemesanan berhasil dicetak.

* **Cetak Pembayaran Vendor**

<img width="518" height="599" alt="image" src="https://github.com/user-attachments/assets/19655e32-aee5-455e-a87d-3f7a0eabc2ce" />

<img width="728" height="364" alt="image" src="https://github.com/user-attachments/assets/0ff1d4f3-7fda-4f48-9657-89cc46a1c050" />

Pada proses Cetak Pembayaran Vendor, program terlebih dahulu menampilkan daftar vendor yang tersedia beserta informasi masing-masing vendor. Pengguna kemudian diminta memasukkan ID Vendor yang ingin dicetak.

Apabila vendor yang dipilih merupakan Vendor Catering, pengguna akan diminta memasukkan jumlah pax terlebih dahulu. Jumlah pax tersebut kemudian dikalikan dengan harga per pax untuk mendapatkan total pembayaran vendor. Setelah itu, program akan mencetak bukti pembayaran yang berisi ID Vendor, nama vendor, jenis masakan, sistem penyajian, harga per pax, jumlah pax, dan total pembayaran.

<img width="711" height="528" alt="image" src="https://github.com/user-attachments/assets/2be0bf36-82a4-4745-b4f3-803ecb60e315" />

Sementara itu, apabila vendor yang dipilih merupakan Vendor Dekorasi, program dapat langsung mencetak bukti pembayaran berdasarkan harga paket dekorasi karena harga yang digunakan merupakan harga paket yang sudah ditentukan. 

* **Kembali ke Menu Utama**

<img width="465" height="602" alt="image" src="https://github.com/user-attachments/assets/e6ab591f-0b3d-4b7a-9cee-880009bbdf87" />

Apabila telah menyelesaikan proses mencetak dokumen, pengguna dapat memilih menu "3" untuk keluar dari Menu Cetak Dokumen dan kembali ke Menu Utama.

---

### 6. Keluar >>>

<img width="892" height="536" alt="image" src="https://github.com/user-attachments/assets/708c8e26-9313-44a9-89e6-500839a36546" />

Apabila pengguna telah selesai melakukan pengelolaan data Wedding Organizer, pengguna dapat memilih menu “6” pada menu utama untuk mengakhiri program. Setelah pengguna memilih menu tersebut, program akan menampilkan pesan “BYEEEE!!” sebagai tanda bahwa program telah selesai dijalankan.

---
