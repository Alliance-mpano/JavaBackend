package demo.alliance.ne.binarysupermarket.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.alliance.ne.binarysupermarket.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @Type(type="uuid-binary")
    private UUID id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "phone",unique = true,length = 100)
    private String phone;

    @Column(name = "email",unique = true,length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role = ERole.CUSTOMER;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

    public User(String name,String phoneNumber, String email) {
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
    }

    public User(String name, String phoneNumber, String email, ERole role) {
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
        this.role = role;
    }

    public User(String name, String phoneNumber, String email,  String password) {
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public User(String name, String phoneNumber, String email, String password, ERole role) {
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
