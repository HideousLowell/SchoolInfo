package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.ExperienceMapper;
import ru.eshakin.schoolinfo.model.dto.ExperienceDto;
import ru.eshakin.schoolinfo.model.entity.Experience;
import ru.eshakin.schoolinfo.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/experience")
public class ExperienceController extends GenericController<Experience, ExperienceDto, Long> {

    public ExperienceController(ExperienceService service, ExperienceMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<ExperienceDto> getDtoClass() {
        return ExperienceDto.class;
    }

    @Override
    protected String getEntityName() {
        return "experience";
    }
}