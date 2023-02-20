package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.Recommendation;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends GenericRepository<Recommendation, Long> {
}
