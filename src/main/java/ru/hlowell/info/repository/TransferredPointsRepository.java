package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.TransferredPoints;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferredPointsRepository extends GenericRepository<TransferredPoints, Long> {
}
