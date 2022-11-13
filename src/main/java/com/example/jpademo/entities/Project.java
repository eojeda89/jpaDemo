package com.example.jpademo.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "projects")
public class Project {
    @Positive(message = "The id must be a positive number.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "The name must not be a blank string")
    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String description;

    @Max(message = "The maximum value is 5", value = 5)
    @Min(message = "The minimum value is 0", value = 0)
    @Column(name = "type")
    private Integer type;

    @Column(name = "createdat")
    @Type(type = "com.example.jpademo.entities.ToTimestamp")
    private LocalDateTime createdAt;

    @Column(name = "updatedat")
    @Type(type = "com.example.jpademo.entities.ToTimestamp")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    @ToString.Exclude
    private Set<Job> jobs = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "pmprojects",
            joinColumns = @JoinColumn(name = "projectid"),
            inverseJoinColumns = @JoinColumn(name = "pmid"))
    @ToString.Exclude
    private Set<User> pms = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return id != null && Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void removeJob(Job job){
        this.jobs.remove(job);
    }

    public void addPM(User user){
        this.pms.add(user);
    }

    public void removePM(User user){
        this.pms.remove(user);
    }
}
