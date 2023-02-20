package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.PeerToPeer;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerToPeerRepository extends GenericRepository<PeerToPeer, Long> {
}
