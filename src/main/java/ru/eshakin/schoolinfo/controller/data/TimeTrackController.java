package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.TimeTrackMapper;
import ru.eshakin.schoolinfo.model.dto.TimeTrackDto;
import ru.eshakin.schoolinfo.model.entity.TimeTrack;
import ru.eshakin.schoolinfo.service.TimeTrackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeTrack")
public class TimeTrackController extends GenericController<TimeTrack, TimeTrackDto, Long> {

    public TimeTrackController(TimeTrackService service, TimeTrackMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<TimeTrackDto> getDtoClass() {
        return TimeTrackDto.class;
    }

    @Override
    protected String getEntityName() {
        return "timeTrack";
    }
}
