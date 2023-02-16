package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.RecommendationRepository;
import ru.eshakin.schoolinfo.model.entity.Recommendation;
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
