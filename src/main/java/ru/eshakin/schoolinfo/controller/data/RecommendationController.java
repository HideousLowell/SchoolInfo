package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.RecommendationMapper;
import ru.eshakin.schoolinfo.model.dto.RecommendationDto;
import ru.eshakin.schoolinfo.model.entity.Recommendation;
import ru.eshakin.schoolinfo.service.RecommendationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommendation")
public class RecommendationController extends GenericController<Recommendation, RecommendationDto, Long> {

    public RecommendationController(RecommendationService service, RecommendationMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<RecommendationDto> getDtoClass() {
        return RecommendationDto.class;
    }

    @Override
    protected String getEntityName() {
        return "recommendation";
    }
}
