package ru.hlowell.info.model.entity;

import ru.hlowell.info.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "procedure_calls")
public class CallBody implements BaseModel {

    @Id
    private Long id;

    @Column(name = "call")
    private String call;
}
