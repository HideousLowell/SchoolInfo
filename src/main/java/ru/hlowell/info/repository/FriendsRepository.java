package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.Friends;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends GenericRepository<Friends, Long> {
}
