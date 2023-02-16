package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Check;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CheckRepository extends GenericRepository<Check, Long> {
    Set<Check> findAllByIdIn(Set<Long> ids);

    List<Check> findAllByPeer(String peerNickName);
}
