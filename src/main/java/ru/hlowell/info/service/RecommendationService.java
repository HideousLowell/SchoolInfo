package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Recommendation;
import ru.hlowell.info.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService extends GenericService<Recommendation, Long> {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        super(recommendationRepository);
        this.recommendationRepository = recommendationRepository;
    }
}
