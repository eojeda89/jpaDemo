package com.example.jpademo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bstatus")
    private Integer status;

    @Column(name = "tgt")
    private String target;

    @Column(name = "src")
    private String source;

    @Column(name = "jobtype")
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @OneToMany(mappedBy = "job", orphanRemoval = true)
    @ToString.Exclude
    private Set<Bundle> bundles = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return id != null && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addBundle(Bundle bundle){
        this.bundles.add(bundle);
    }

    public void removeBundle(Bundle bundle){
        this.bundles.remove(bundle);
    }
}