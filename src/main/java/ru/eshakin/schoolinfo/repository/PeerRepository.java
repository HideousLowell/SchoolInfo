package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Peer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeerRepository extends GenericRepository<Peer, String> {
    Optional<Peer> findPeerByNickname(String nickname);
}
