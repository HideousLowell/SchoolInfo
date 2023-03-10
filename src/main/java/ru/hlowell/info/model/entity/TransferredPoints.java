package ru.hlowell.info.model.entity;

import ru.hlowell.info.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "transferred_points")
public class TransferredPoints implements BaseModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transferred_points_id_generator"
    )
    @SequenceGenerator(
            name = "transferred_points_id_generator",
            sequenceName = "transferred_points_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checking_peer", referencedColumnName = "nickname", nullable = false)
    private Peer checkingPeer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checked_peer", referencedColumnName = "nickname", nullable = false)
    private Peer checkedPeer;

    @Column(name = "points_amount")
    private Long amount;
}
