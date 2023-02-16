package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.model.entity.Check;
import ru.eshakin.schoolinfo.service.CheckService;
import ru.eshakin.schoolinfo.model.dto.ExperienceDto;
import ru.eshakin.schoolinfo.model.entity.Experience;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper extends GenericMapper<Experience, ExperienceDto> {

    private final CheckService checkService;

    public ExperienceMapper(CheckService checkService) {
        super(Experience.class, ExperienceDto.class);
        this.checkService = checkService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Experience.class, ExperienceDto.class).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ExperienceDto.class, Experience.class).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ExperienceDto source, Experience destination) throws EntityNotFoundException {
        Long id = source.getCheckId();
        Check check = checkService.getByIdOrElseThrow(id);
        destination.setCheck(check);
    }

    @Override
    void mapSpecificFields(Experience source, ExperienceDto destination) {
        destination.setCheckId(source.getCheck().getId());
    }


}
