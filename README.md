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

## Related Article
[Implementasi CRUD Menggunakan Java Persistance API dan Hibernate ORM](https://medium.com/@ichwansholihin/implementasi-crud-menggunakan-java-persistance-api-dan-hibernate-orm-a96f0987d5eb)

