package ru.eshakin.schoolinfo.model.entity;

import ru.eshakin.schoolinfo.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task implements BaseModel {

    @Id
    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_task", referencedColumnName = "title")
    private Task parentTask;

    @Column(name = "max_xp", nullable = false)
    private Long maxExperience;
}
