package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Recommendation;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends GenericRepository<Recommendation, Long> {
}
