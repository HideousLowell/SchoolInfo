package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.CheckMapper;
import ru.eshakin.schoolinfo.model.dto.CheckDto;
import ru.eshakin.schoolinfo.model.entity.Check;
import ru.eshakin.schoolinfo.service.CheckService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checks")
public class CheckController extends GenericController<Check, CheckDto, Long> {

    public CheckController(CheckService service, CheckMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<CheckDto> getDtoClass() {
        return CheckDto.class;
    }

    @Override
    protected String getEntityName() {
        return "checks";
    }
}