package com.example.jpademo.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Include
    @Column(name = "fullname")
    private String fullName;

    @ToString.Include
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createdat")
    @Type(type = "com.example.jpademo.entities.ToTimestamp")
    private LocalDateTime createdAt;

    @Column(name = "updatedat")
    @Type(type = "com.example.jpademo.entities.ToTimestamp")
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "pms")
    private Set<Project> projects = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}