package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.Peer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeerRepository extends GenericRepository<Peer, String> {
    Optional<Peer> findPeerByNickname(String nickname);

    @Query(value = "select nickname from peers",
            nativeQuery = true)
    List<String> findAllNicknames();
}
