package co.com.bancolombia.r2dbc;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_entity")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
