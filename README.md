## Java Persistance API Notes

* Project ini merupakan referensi belajar ORM (Object Relational Mapping) yakni kemampuan untuk membuat database seperti di class Object Java tanpa menggunakan Query.
* Class Entity wajib memiliki default constructor non-parameter agar JPA dapat membuat objec baru ketika melakukan mapping data dari table ke entity.
* Entity di JPA wajib merepresentasikan Id dengan annotation @Id.
* Untuk konfigurasi root, username dan password serta driver ke mysql, buat file `META-INF/persistance.xml`.
* `EntityManagerFactory` (interface yg memanggil konfigurasi jpa) cukup dibuat sekali saja.