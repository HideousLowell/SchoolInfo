package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.PeerToPeerMapper;
import ru.eshakin.schoolinfo.model.dto.PeerToPeerDto;
import ru.eshakin.schoolinfo.model.entity.PeerToPeer;
import ru.eshakin.schoolinfo.service.PeerToPeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peerToPeer")
public class PeerToPeerController extends GenericController<PeerToPeer, PeerToPeerDto, Long> {

    public PeerToPeerController(PeerToPeerService service, PeerToPeerMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<PeerToPeerDto> getDtoClass() {
        return PeerToPeerDto.class;
    }

    @Override
    protected String getEntityName() {
        return "peerToPeer";
    }
}

