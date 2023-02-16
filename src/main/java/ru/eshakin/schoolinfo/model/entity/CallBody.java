package ru.eshakin.schoolinfo.model.entity;

import ru.eshakin.schoolinfo.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "procedure_calls")
public class CallBody implements BaseModel {

    @Id
    private Long id;

    @Column(name = "call")
    private String call;
}
