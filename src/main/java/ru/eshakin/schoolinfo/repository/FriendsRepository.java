package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Friends;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends GenericRepository<Friends, Long> {
}
