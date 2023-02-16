package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.VerterMapper;
import ru.eshakin.schoolinfo.model.dto.VerterDto;
import ru.eshakin.schoolinfo.model.entity.Verter;
import ru.eshakin.schoolinfo.service.VerterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/verter")
public class VerterController extends GenericController<Verter, VerterDto, Long> {

    public VerterController(VerterService service, VerterMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<VerterDto> getDtoClass() {
        return VerterDto.class;
    }

    @Override
    protected String getEntityName() {
        return "verter";
    }
}
