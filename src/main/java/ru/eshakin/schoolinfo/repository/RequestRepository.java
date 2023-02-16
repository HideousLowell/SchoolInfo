package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.CallBody;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends GenericRepository<CallBody, Long> {
}

