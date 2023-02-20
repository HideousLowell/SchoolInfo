package ru.hlowell.info.model.entity;

import ru.hlowell.info.model.BaseModel;
import ru.hlowell.info.model.Status;
import ru.hlowell.info.util.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "verter")
public class Verter implements BaseModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "verter_id_generator"
    )
    @SequenceGenerator(
            name = "verter_id_generator",
            sequenceName = "verter_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id", referencedColumnName = "id", nullable = false)
    private Check check;

    @Convert(converter = StatusConverter.class)
    @Column(name = "state")
    private Status status;

    @Column(name = "time")
    private LocalTime time;
}
