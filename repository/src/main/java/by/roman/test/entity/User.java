package by.roman.test.entity;


import by.roman.test.enumerate.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surName;

    @Column(name = "user_middlename")
    private String middleName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", name = " + name +
                ", surName = " + surName +
                ", middleName = " + middleName +
                ", email = " + email +
                ", role = " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
