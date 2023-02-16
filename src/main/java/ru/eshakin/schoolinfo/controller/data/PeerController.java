package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.PeerMapper;
import ru.eshakin.schoolinfo.model.dto.PeerDto;
import ru.eshakin.schoolinfo.model.entity.Peer;
import ru.eshakin.schoolinfo.service.PeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peer")
public class PeerController extends GenericController<Peer, PeerDto, String> {

    public PeerController(PeerService service, PeerMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<PeerDto> getDtoClass() {
        return PeerDto.class;
    }

    @Override
    protected String getEntityName() {
        return "peer";
    }
}
