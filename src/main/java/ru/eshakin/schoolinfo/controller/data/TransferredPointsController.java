package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.TransferredPointsMapper;
import ru.eshakin.schoolinfo.model.dto.TransferredPointsDto;
import ru.eshakin.schoolinfo.model.entity.TransferredPoints;
import ru.eshakin.schoolinfo.service.TransferredPointsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transferredPoints")
public class TransferredPointsController extends GenericController<TransferredPoints, TransferredPointsDto, Long> {

    public TransferredPointsController(TransferredPointsService service, TransferredPointsMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<TransferredPointsDto> getDtoClass() {
        return TransferredPointsDto.class;
    }

    @Override
    protected String getEntityName() {
        return "transferredPoints";
    }
}
