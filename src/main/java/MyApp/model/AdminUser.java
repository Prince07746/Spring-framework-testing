package MyApp.model;


import jakarta.persistence.*;

@Entity(name="userAdmin")
@Table(
        name="userAdmin",
        uniqueConstraints = @UniqueConstraint(name="unique_email",columnNames = "EMAIL")
)
public class AdminUser {

    @Id
    @SequenceGenerator(
            name="admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    @Column(
            name="ID",
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column(
            name="NAME",
            nullable = false,
            updatable = true,
            length = 50,
            columnDefinition="TEXT"
    )
    private String name;

    @Column(
            name="LAST_NAME",
            nullable = false,
            updatable = true,
            length = 50,
            columnDefinition="TEXT"
    )
    private String lastname;

    @Column(
            name="EMAIL",
            nullable = false,
            updatable = true,
            length = 50,
            columnDefinition="TEXT"
    )
    private String email;

    @Column(
            name="AGE",
            nullable = false
    )
    private int age;

    public AdminUser(Long id, String name, String lastname, String email, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
    public AdminUser(String name, String lastname, String email, int age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public AdminUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
