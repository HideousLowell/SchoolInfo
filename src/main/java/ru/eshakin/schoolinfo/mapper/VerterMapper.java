package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.service.CheckService;
import ru.eshakin.schoolinfo.model.Status;
import ru.eshakin.schoolinfo.model.dto.VerterDto;
import ru.eshakin.schoolinfo.model.entity.Check;
import ru.eshakin.schoolinfo.model.entity.Verter;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class VerterMapper extends GenericMapper<Verter, VerterDto> {

    private final CheckService checkService;

    public VerterMapper(CheckService checkService) {
        super(Verter.class, VerterDto.class);
        this.checkService = checkService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Verter.class, VerterDto.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(VerterDto.class, Verter.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(VerterDto source, Verter destination)
            throws EntityNotFoundException, IllegalArgumentException {
        Long id = source.getCheckId();
        Check check = checkService.getByIdOrElseThrow(id);
        destination.setCheck(check);

        Status status = Status.valueOf(source.getStatus());
        destination.setStatus(status);
    }

    @Override
    void mapSpecificFields(Verter source, VerterDto destination) {
        destination.setCheckId(source.getCheck().getId());
        destination.setStatus(source.getStatus().name());
    }

}
