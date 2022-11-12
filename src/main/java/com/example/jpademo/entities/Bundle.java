package com.example.jpademo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "bundles")
public class Bundle {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bundletype")
    private Integer type;

    @Column(name = "status")
    private Integer status;

    @Column(name = "showtranslation")
    private Boolean showTranslation;

    @ManyToOne
    @JoinColumn(name = "jobId")
    private Job job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bundle bundle = (Bundle) o;
        return id != null && Objects.equals(id, bundle.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}