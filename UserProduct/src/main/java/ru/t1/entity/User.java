package ru.t1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Product> products;

//    @Override
//    public String toString() {
//        return "User [id=" + id + ", username=" + username + ", products=" + products + "]";
//    }
}
