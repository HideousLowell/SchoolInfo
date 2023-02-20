package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.CallBody;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends GenericRepository<CallBody, Long> {
}

