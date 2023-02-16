package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.PeerToPeer;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerToPeerRepository extends GenericRepository<PeerToPeer, Long> {
}
