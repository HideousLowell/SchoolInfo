package ru.hlowell.info.model.entity;

import ru.hlowell.info.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "peers")
public class Peer implements BaseModel {

    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
}
