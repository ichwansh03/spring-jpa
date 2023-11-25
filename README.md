## Java Persistance API Notes

* Project ini merupakan referensi belajar ORM (Object Relational Mapping) yakni kemampuan untuk membuat database seperti di class Object Java tanpa menggunakan Query.
* JPA (Java Persistence API) merupakan salah satu standarisasi untuk ORM di java. Link => [Specification](https://jakarta.ee/specifications/persistence/)
* ORM adalah teknik mapping antara database dengan object (class) pada Java dengan tujuan untuk memanipulasi data di database layaknya memanipulasi data object menggunakan framework Hibernate.
* Tools ORM di java:
    - Hibernate: mendukung database independent query atau HQL (Hibernate Query Language), menggunakan default method dari hibernate yg dapat digenerate menjadi SQL.
    - TopLink/EclipseLink: menyimpan data dalam XML atau database relasional dan dapat diubah dari object (class) serta independen antara object model dan SQL schema.
    - Apache OpenJPA: stand-alone POJO (Plain Old Java Object) persistence layer.
    - MyBatis: menekankan penggunaan query SQL dengan annotation dan mendukung dynamic SQL.
* Class Entity wajib memiliki default constructor non-parameter agar JPA dapat membuat objec baru ketika melakukan mapping data dari table ke entity.
* Entity di JPA wajib merepresentasikan Id dengan annotation @Id.
* Untuk konfigurasi root, username dan password serta driver ke mysql, buat file `META-INF/persistance.xml`.
* `EntityManagerFactory` (interface yg memanggil konfigurasi jpa) cukup dibuat sekali saja.
* Anotasi `@Transactional` digunakan untuk melakukan management transaksi jika menggunakan query/JPA secara manual. Anotasi ini tidak dapat digunakan pada class unit-test. [Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
* Menggunakan JPA QL berdasarkan nama method pada docs berikut. [Docs](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
* Jika ingin menggunakan query relation, buat di interface repository child lalu tambahkan method findByNamaTableParent_Field.
* Default `@Transaction` repository adalah `readOnly = true`, jika ingin diubah, ubah versi transaction nya di method.
* Anotasi `@Modifying` hanya digunakan untuk query update dan delete.
* JPA juga support dengan inheritance. [Docs](https://www.baeldung.com/hibernate-inheritance) 
* Jika terdapat relasi IS-A dan column dari tiap entity tidak banyak, gunakan single inheritance serta annotation discriminator column untuk menambahkan column yg berbeda.
* Jika relasinya ke primary key dari table lain, gunakan Join Table inheritance.
* Jika memiliki perbedaan column yg signifikan pada setiap table, gunakan table per class inheritance. Table per class inheritance memiliki konsep yg sama seperti Join Columnn, namun jika menggunakan inheritance ini akan sangat lambat jika langsung query ke parent class.
* Jika terdapat column yg sama pada setiap entity namun bukan bagian dari IS-A relationship, gunakan `MappedSuperClass`, konsepnya sama dengan abstract class dan class ini disarankan menggunaan abstract agar tidak dibaca sebagai entity dan dapat diturunkan pada setiap entity yg membutuhkan.

## Related Article
[Implementasi CRUD Menggunakan Java Persistance API dan Hibernate ORM](https://medium.com/@ichwansholihin/implementasi-crud-menggunakan-java-persistance-api-dan-hibernate-orm-a96f0987d5eb)

