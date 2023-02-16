package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.TransferredPoints;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferredPointsRepository extends GenericRepository<TransferredPoints, Long> {
}
